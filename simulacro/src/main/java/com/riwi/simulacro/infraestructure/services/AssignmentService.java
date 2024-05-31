package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.AssignmentRequest;
import com.riwi.simulacro.api.dto.response.AssignmentResponse;
import com.riwi.simulacro.domain.entities.Assignment;
import com.riwi.simulacro.domain.entities.Lesson;
import com.riwi.simulacro.domain.repositories.AssignmentRepository;
import com.riwi.simulacro.domain.repositories.LessonRepository;
import com.riwi.simulacro.infraestructure.abstract_services.IAssignmentService;
import com.riwi.simulacro.infraestructure.mappers.AssignmentMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public AssignmentResponse create(AssignmentRequest assignmentRequest) {
        Assignment assignment = assignmentMapper.toAssignment(assignmentRequest);
        Lesson lesson = lessonRepository.findById(assignmentRequest.getLessonId())
                .orElseThrow(() -> new IdNotFoundException("LESSON", assignmentRequest.getLessonId()));

        assignment.setLessonId(lesson);
        Assignment saveAssignment = assignmentRepository.save(assignment);
        return assignmentMapper.toAssignmentResponse(saveAssignment);
    }

    @Override
    public AssignmentResponse update(Integer id, AssignmentRequest assignmentRequest) {
        Assignment existingAssignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ASSIGNMENT", id));

        assignmentMapper.updateFromAssignmentRequest(assignmentRequest, existingAssignment);
        Assignment updateAssignment = assignmentRepository.save(existingAssignment);
        return assignmentMapper.toAssignmentResponse(updateAssignment);
    }

    @Override
    public void delete(Integer id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public Page<AssignmentResponse> getAll(Pageable pageable) {
        Page<Assignment> assignmentPage = assignmentRepository.findAll(pageable);
        return assignmentPage.map(assignmentMapper::toAssignmentResponse);
    }

    @Override
    public Optional<AssignmentResponse> getById(Integer id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        if (assignment.isEmpty()) throw new IdNotFoundException("ASSIGNMENT", id);
        return assignment.map(assignmentMapper::toAssignmentResponse);
    }
}
