package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.SubmissionRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;

public interface ISubmissionService extends CreateReadDeleteService<SubmissionRequest, SubmissionResponse, Long>,UpdateService<SubmissionRequest, SubmissionResponse, Long> {
}
