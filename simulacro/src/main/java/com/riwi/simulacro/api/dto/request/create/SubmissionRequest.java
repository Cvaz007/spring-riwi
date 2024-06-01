package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.SubmissionUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest extends SubmissionUpdateRequest {
    private Long userId;
    private Long assignmentId;
    private Date submissionDate;
}
