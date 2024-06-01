package com.example.demo.infraestructure.abstract_services;

import com.example.demo.api.dto.request.create.ProjectRequest;
import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import com.example.demo.api.dto.response.ProjectResponse;

public interface IProjectService extends
        CreateReadDeleteService<ProjectRequest, ProjectResponse, Long>,
        UpdateService<ProjectUpdateRequest, ProjectResponse, Long>
{
}
