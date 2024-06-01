package com.example.demo.infraestructure.abstract_services;

import com.example.demo.api.dto.request.create.UserRequest;
import com.example.demo.api.dto.request.update.UserUpdateRequest;
import com.example.demo.api.dto.response.UserResponse;

public interface IUserService extends
        CreateReadDeleteService<UserRequest, UserResponse, Long>,
        UpdateService<UserUpdateRequest, UserResponse, Long>
{
}
