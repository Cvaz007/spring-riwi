package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.UserRequest;
import com.riwi.simulacro.api.dto.response.UserResponse;

public interface IUserService extends CRUDService<UserRequest, UserResponse, Integer> {
}
