package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.EnrollmentRequest;
import com.riwi.simulacro.api.dto.response.EnrollmentResponse;
import com.riwi.simulacro.domain.entities.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(target = "id", ignore = true)
    Enrollment toEnrollment(EnrollmentRequest enrollmentRequest);

    EnrollmentResponse toEnrollmentResponse(Enrollment enrollment);

    void updateFromEnrollmentRequest(EnrollmentRequest enrollmentRequest, @MappingTarget Enrollment enrollment);
}
