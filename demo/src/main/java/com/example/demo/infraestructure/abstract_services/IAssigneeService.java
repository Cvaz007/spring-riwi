package com.example.demo.infraestructure.abstract_services;

import com.example.demo.api.dto.request.create.AssigneeRequest;
import com.example.demo.api.dto.response.AssigneeResponse;

public interface IAssigneeService extends
        CreateReadDeleteService<AssigneeRequest, AssigneeResponse, Long>
{
}
