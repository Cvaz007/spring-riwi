package com.riwi.simulacro.infraestructure.mappers;

import com.riwi.simulacro.api.dto.request.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;
import com.riwi.simulacro.domain.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "id", ignore = true)
    Message toMessage(MessageRequest messageRequest);

    MessageResponse toMessageResponse(Message message);

    void updateFromMessageRequest(MessageRequest messageRequest, @MappingTarget Message message);
}
