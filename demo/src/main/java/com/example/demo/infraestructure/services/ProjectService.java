package com.example.demo.infraestructure.services;

import com.example.demo.api.dto.request.create.FileRequest;
import com.example.demo.api.dto.request.create.ProjectRequest;
import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import com.example.demo.api.dto.response.ProjectResponse;
import com.example.demo.domain.entities.File;
import com.example.demo.domain.entities.Project;
import com.example.demo.domain.repositories.ProjectRepository;
import com.example.demo.infraestructure.abstract_services.IFileService;
import com.example.demo.infraestructure.abstract_services.IProjectService;
import com.example.demo.infraestructure.mappers.ProjectMapper;
import com.example.demo.util.exeptions.IdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ProjectService implements IProjectService {
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final ProjectMapper projectMapper;
    @Autowired
    private final IFileService fileService;

    @Override
    public ProjectResponse create(ProjectRequest projectRequest) {
        Project project = projectMapper.toProject(projectRequest);
        Project saveProject = projectRepository.save(project);

        if (projectRequest.getFiles() != null) fileService.createFilesFromProject(projectRequest.getFiles(), saveProject.getId());

        return projectMapper.toProjectResponse(saveProject);
    }

    @Override
    public ProjectResponse update(Long id, ProjectUpdateRequest projectRequest) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ASSIGNMENT", id));

        projectMapper.updateFromProjectRequest(projectRequest, existingProject);
        Project updateProject = projectRepository.save(existingProject);
        return projectMapper.toProjectResponse(updateProject);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Page<ProjectResponse> getAll(Pageable pageable) {
        Page<Project> projectPage = projectRepository.findAll(pageable);
        return projectPage.map(projectMapper::toProjectResponse);
    }

    @Override
    public Optional<ProjectResponse> getById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()) throw new IdNotFoundException("ASSIGNMENT", id);
        return project.map(projectMapper::toProjectResponse);
    }
}
