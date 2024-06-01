package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.LessonRequest;
import com.riwi.simulacro.api.dto.request.update.LessonUpdateRequest;
import com.riwi.simulacro.api.dto.response.LessonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILessonService extends CreateReadDeleteService<LessonRequest, LessonResponse, Long>,UpdateService<LessonUpdateRequest, LessonResponse, Long> {
}
