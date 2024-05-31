package com.riwi.simulacro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {
    private Integer id;
    private String content;
    private Date submissionDate;
    private BigDecimal grade;

}