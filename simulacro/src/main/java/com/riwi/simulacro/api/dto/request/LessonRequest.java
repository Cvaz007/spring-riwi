package com.riwi.simulacro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {
    private String lessonTitle;
    private String content;
    private Integer courseId;
}
