package com.riwi.simulacro.api.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {
    private Long userId;
    private Long courseId;
    private Date enrollmentDate;
}