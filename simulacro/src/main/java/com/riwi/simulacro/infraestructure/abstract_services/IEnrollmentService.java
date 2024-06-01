package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;

public interface IEnrollmentService extends CreateReadDeleteService<EnrollmentRequest, EnrollmentResponse, Long>, UpdateService<EnrollmentRequest, EnrollmentResponse, Long> {
}
