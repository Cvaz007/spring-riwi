package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.SubmissionRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;

public interface ISubmissionService extends CRUDService<SubmissionRequest, SubmissionResponse, Long> {
}
