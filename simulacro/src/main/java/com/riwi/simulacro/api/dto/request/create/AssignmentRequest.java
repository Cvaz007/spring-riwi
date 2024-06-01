package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.AssignmentUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest extends AssignmentUpdateRequest {
    private Long lessonId;
}
