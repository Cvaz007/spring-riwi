package com.riwi.simulacro.api.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonUpdateRequest {
    private String lessonTitle;
    private String content;
}
