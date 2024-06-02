package com.example.demo.api.controllers;

import com.example.demo.api.dto.request.create.ProjectRequest;
import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import com.example.demo.api.dto.response.ProjectResponse;
import com.example.demo.infraestructure.abstract_services.IProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {
    @Autowired
    private final IProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> saveProject(@Validated @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.create(projectRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(
            @PathVariable Long id,
            @Validated @RequestBody ProjectUpdateRequest projectRequest
    ) {
        return ResponseEntity.ok(projectService.update(id, projectRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjectResponse>> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(projectService.getAll(pageable));
    }
}
