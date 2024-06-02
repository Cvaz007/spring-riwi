package com.example.demo.api.controllers;

import com.example.demo.api.dto.request.create.FileRequest;
import com.example.demo.api.dto.request.update.FileUpdateRequest;
import com.example.demo.api.dto.response.FileResponse;
import com.example.demo.infraestructure.abstract_services.IFileService;
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
@RequestMapping("/files")
@AllArgsConstructor
public class FileController {
    @Autowired
    private final IFileService fileService;

    @PutMapping("/{id}")
    public ResponseEntity<FileResponse> updateFile(
            @PathVariable Long id,
            @Validated @RequestBody FileUpdateRequest fileRequest
    ) {
        return ResponseEntity.ok(fileService.update(id, fileRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
        fileService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FileResponse>> getFile(@PathVariable Long id) {
        return ResponseEntity.ok(fileService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<FileResponse>> getAllFiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(fileService.getAll(pageable));
    }
}
