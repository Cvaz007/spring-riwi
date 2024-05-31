package com.riwi.simulacro.api.dto.request;

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
public class SubmissionRequest {
    private Long userId;
    private Long assignmentId;
    private String content;
    private Date submissionDate;
    private BigDecimal grade;
}
