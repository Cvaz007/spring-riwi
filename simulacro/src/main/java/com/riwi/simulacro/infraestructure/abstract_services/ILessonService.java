package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.LessonRequest;
import com.riwi.simulacro.api.dto.response.LessonResponse;

public interface ILessonService extends CRUDService<LessonRequest, LessonResponse, Integer> {
}
