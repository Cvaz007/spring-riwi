package com.riwi.simulacro.api.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentUpdateRequest {
    private String assignmentTitle;
    private String description;
    private Date dueDate;
}
