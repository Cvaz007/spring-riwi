package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.UserRequest;
import com.riwi.simulacro.api.dto.response.UserResponse;
import com.riwi.simulacro.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    void updateFromUserRequest(UserRequest userRequest, @MappingTarget User user);
}
