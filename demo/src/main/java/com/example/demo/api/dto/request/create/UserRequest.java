package com.example.demo.api.dto.request.create;

import com.example.demo.api.dto.request.update.UserUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends UserUpdateRequest {
    private String fullName;
    private String email;
}
