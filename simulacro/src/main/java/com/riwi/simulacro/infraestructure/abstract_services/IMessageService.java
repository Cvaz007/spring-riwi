package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.create.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;

public interface IMessageService extends CreateReadDeleteService<MessageRequest, MessageResponse, Long>, UpdateService<MessageRequest, MessageResponse, Long> {
}
