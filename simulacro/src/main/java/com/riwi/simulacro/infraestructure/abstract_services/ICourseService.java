package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.CourseRequest;
import com.riwi.simulacro.api.dto.response.CourseResponse;

public interface ICourseService extends CRUDService<CourseRequest, CourseResponse, Long> {
}
