package com.example.demo.api.dto.response;

import com.example.demo.domain.entities.Project;
import com.example.demo.domain.entities.User;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssigneeResponse {
    private Long id;
    private Project projectId;
    private User userId;
}
