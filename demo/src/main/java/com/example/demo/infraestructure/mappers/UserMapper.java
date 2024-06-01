package com.example.demo.infraestructure.mappers;

import com.example.demo.api.dto.request.create.UserRequest;
import com.example.demo.api.dto.request.update.UserUpdateRequest;
import com.example.demo.api.dto.response.UserResponse;
import com.example.demo.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    void updateFromUserRequest(UserUpdateRequest userRequest, @MappingTarget User user);
}
