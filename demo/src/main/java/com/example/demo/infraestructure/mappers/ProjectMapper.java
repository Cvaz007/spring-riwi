package com.example.demo.infraestructure.mappers;

import com.example.demo.api.dto.request.create.ProjectRequest;
import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import com.example.demo.api.dto.response.ProjectResponse;
import com.example.demo.domain.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "files", ignore = true)
    })
    Project toProject(ProjectRequest projectRequest);

    ProjectResponse toProjectResponse(Project project);

    void updateFromProjectRequest(ProjectUpdateRequest projectRequest, @MappingTarget Project project);
}
