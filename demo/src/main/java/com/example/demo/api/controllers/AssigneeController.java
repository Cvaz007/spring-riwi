package com.example.demo.api.controllers;

import com.example.demo.api.dto.request.create.AssigneeRequest;
import com.example.demo.api.dto.response.AssigneeResponse;
import com.example.demo.infraestructure.abstract_services.IAssigneeService;
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
@RequestMapping("/assignees")
@AllArgsConstructor
public class AssigneeController {
    @Autowired
    private final IAssigneeService assigneeService;

    @PostMapping
    public ResponseEntity<AssigneeResponse> saveAssignee(@Validated @RequestBody AssigneeRequest assigneeRequest) {
        return ResponseEntity.ok(assigneeService.create(assigneeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignee(@PathVariable Long id) {
        assigneeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AssigneeResponse>> getAssignee(@PathVariable Long id) {
        return ResponseEntity.ok(assigneeService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<AssigneeResponse>> getAllAssignees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(assigneeService.getAll(pageable));
    }
}
