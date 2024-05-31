package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;
import com.riwi.simulacro.domain.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CourseMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "instructorId.id", source = "instructorId")
    })
    Course toCourse(CourseRequest courseRequest);

    CourseResponse toCourseResponse(Course course);

    @Mapping(target = "instructorId.id", source = "instructorId")
    void updateFromCourseRequest(CourseRequest courseRequest, @MappingTarget Course course);
}
