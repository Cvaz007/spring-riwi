package com.riwi.simulacro.api.controllers;

import com.riwi.simulacro.api.dto.request.UserRequest;
import com.riwi.simulacro.api.dto.response.UserResponse;
import com.riwi.simulacro.infraestructure.abstract_services.IUserService;
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
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@Validated @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.create(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @Validated @RequestBody UserRequest userRequest
    ) {
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(userService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponse>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}
