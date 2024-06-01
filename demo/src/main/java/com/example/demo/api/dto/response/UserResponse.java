package com.example.demo.api.dto.response;

import com.example.demo.domain.entities.Project;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
    private String email;
}
