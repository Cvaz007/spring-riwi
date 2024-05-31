package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.LessonRequest;
import com.riwi.simulacro.api.dto.response.LessonResponse;
import com.riwi.simulacro.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "id", ignore = true)
    Lesson toLesson(LessonRequest lessonRequest);

    LessonResponse toLessonResponse(Lesson lesson);

    void updateFromLessonRequest(LessonRequest lessonRequest, @MappingTarget Lesson lesson);
}
