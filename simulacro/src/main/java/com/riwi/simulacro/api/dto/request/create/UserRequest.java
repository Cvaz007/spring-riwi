package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.UserUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends UserUpdateRequest {
    private String role;
}
