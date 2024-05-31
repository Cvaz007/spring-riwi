package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;
import com.riwi.simulacro.domain.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "id", ignore = true)
    Course toCourse(CourseRequest courseRequest);

    CourseResponse toCourseResponse(Course course);

    void updateFromCourseRequest(CourseRequest courseRequest, @MappingTarget Course course);
}
