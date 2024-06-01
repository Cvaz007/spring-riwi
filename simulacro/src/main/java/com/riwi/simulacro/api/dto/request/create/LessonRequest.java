package com.riwi.simulacro.api.dto.request.create;

import com.riwi.simulacro.api.dto.request.update.LessonUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest extends LessonUpdateRequest {
    private Long courseId;
}
