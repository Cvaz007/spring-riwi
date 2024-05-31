package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;

public interface IEnrollmentService extends CRUDService<EnrollmentRequest, EnrollmentResponse, Long> {
}
