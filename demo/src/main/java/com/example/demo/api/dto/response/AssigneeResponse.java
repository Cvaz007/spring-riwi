package com.example.demo.api.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssigneeResponse {
    private Long id;
    private ProjectResponse projectId;
    private UserResponse userId;
}
