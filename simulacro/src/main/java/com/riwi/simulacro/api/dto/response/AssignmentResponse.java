package com.riwi.simulacro.api.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentResponse {
    private Integer id;
    private String assignmentTitle;
    private String description;
    private Data dueDate;

}
