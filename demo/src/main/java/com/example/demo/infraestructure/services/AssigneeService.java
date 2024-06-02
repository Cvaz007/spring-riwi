package com.example.demo.infraestructure.services;

import com.example.demo.api.dto.request.create.AssigneeRequest;
import com.example.demo.api.dto.response.AssigneeResponse;
import com.example.demo.domain.entities.Assignee;
import com.example.demo.domain.entities.Project;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.repositories.AssigneeRepository;
import com.example.demo.domain.repositories.ProjectRepository;
import com.example.demo.domain.repositories.UserRepository;
import com.example.demo.infraestructure.abstract_services.IAssigneeService;
import com.example.demo.infraestructure.helpers.EmailHelper;
import com.example.demo.infraestructure.mappers.AssigneeMapper;
import com.example.demo.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssigneeService implements IAssigneeService {
    @Autowired
    private final AssigneeRepository assigneeRepository;
    @Autowired
    private final AssigneeMapper assigneeMapper;
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final EmailHelper emailHelper;

    @Override
    public AssigneeResponse create(AssigneeRequest assigneeRequest) {
        Assignee assignee = assigneeMapper.toAssignee(assigneeRequest);
        Project project = projectRepository.findById(assigneeRequest.getProjectId())
                .orElseThrow(() -> new IdNotFoundException("PROJECT", assigneeRequest.getProjectId()));
        User user = userRepository.findById(assigneeRequest.getUserId())
                .orElseThrow(() -> new IdNotFoundException("USER", assigneeRequest.getUserId()));

        assignee.setProjectId(project);
        assignee.setUserId(user);
        Assignee saveAssignee = assigneeRepository.save(assignee);
        if (Objects.nonNull(user.getEmail()))
            emailHelper.sendEmail(user.getEmail(), "Asignado a un proyecto: "+project.getName(),"Felicidades te han cambiado de proyecto", LocalDateTime.now());
        return assigneeMapper.toAssigneeResponse(saveAssignee);
    }

    @Override
    public void delete(Long id) {
        assigneeRepository.deleteById(id);
    }

    @Override
    public Page<AssigneeResponse> getAll(Pageable pageable) {
        Page<Assignee> assigneePage = assigneeRepository.findAll(pageable);
        return assigneePage.map(assigneeMapper::toAssigneeResponse);
    }

    @Override
    public Optional<AssigneeResponse> getById(Long id) {
        Optional<Assignee> assignee = assigneeRepository.findById(id);
        if (assignee.isEmpty()) throw new IdNotFoundException("ASSIGNMENT", id);
        return assignee.map(assigneeMapper::toAssigneeResponse);
    }
}
