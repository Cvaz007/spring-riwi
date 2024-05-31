package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.SubmissionRequest;
import com.riwi.simulacro.api.dto.response.SubmissionResponse;
import com.riwi.simulacro.domain.entities.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {
    @Mapping(target = "id", ignore = true)
    Submission toSubmission(SubmissionRequest submissionRequest);

    SubmissionResponse toSubmissionResponse(Submission submission);

    void updateFromSubmissionRequest(SubmissionRequest submissionRequest, @MappingTarget Submission submission);
}
