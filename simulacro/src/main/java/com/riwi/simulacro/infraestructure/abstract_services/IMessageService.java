package com.riwi.simulacro.infraestructure.abstract_services;

import com.riwi.simulacro.api.dto.request.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;

public interface IMessageService extends CRUDService<MessageRequest, MessageResponse, Integer> {
}
