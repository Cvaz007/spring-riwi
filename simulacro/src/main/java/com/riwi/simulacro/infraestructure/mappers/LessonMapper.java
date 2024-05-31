package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.LessonRequest;
import com.riwi.simulacro.api.dto.response.LessonResponse;
import com.riwi.simulacro.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface LessonMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "courseId.id", source = "courseId")
    })
    Lesson toLesson(LessonRequest lessonRequest);

    LessonResponse toLessonResponse(Lesson lesson);

    @Mapping(target = "courseId.id", source = "courseId")
    void updateFromLessonRequest(LessonRequest lessonRequest, @MappingTarget Lesson lesson);
}
