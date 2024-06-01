package com.example.demo.infraestructure.mappers;

import com.example.demo.api.dto.request.create.AssigneeRequest;
import com.example.demo.api.dto.response.AssigneeResponse;
import com.example.demo.domain.entities.Assignee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AssigneeMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "projectId.id", source = "projectId"),
            @Mapping(target = "userId.id", source = "userId")
    })
    Assignee toAssignee(AssigneeRequest assigneeRequest);

    AssigneeResponse toAssigneeResponse(Assignee assignee);

}
