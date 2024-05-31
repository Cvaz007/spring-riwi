package com.riwi.simulacro.infraestructure.services;

import com.riwi.simulacro.api.dto.request.MessageRequest;
import com.riwi.simulacro.api.dto.response.MessageResponse;
import com.riwi.simulacro.domain.entities.Course;
import com.riwi.simulacro.domain.entities.Message;
import com.riwi.simulacro.domain.entities.User;
import com.riwi.simulacro.domain.repositories.CourseRepository;
import com.riwi.simulacro.domain.repositories.MessageRepository;
import com.riwi.simulacro.domain.repositories.UserRepository;
import com.riwi.simulacro.infraestructure.abstract_services.IMessageService;
import com.riwi.simulacro.infraestructure.mappers.MessageMapper;
import com.riwi.simulacro.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public MessageResponse create(MessageRequest messageRequest) {
        Message message = messageMapper.toMessage(messageRequest);
        Course course = courseRepository.findById(messageRequest.getCourseId())
                .orElseThrow(() -> new IdNotFoundException("COURSE", messageRequest.getCourseId()));
        User senderId = userRepository.findById(messageRequest.getSenderId())
                .orElseThrow(() -> new IdNotFoundException("USER", messageRequest.getSenderId()));
        User receiverId = userRepository.findById(messageRequest.getReceiverId())
                .orElseThrow(() -> new IdNotFoundException("USER", messageRequest.getReceiverId()));

        message.setCourseId(course);
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        Message saveMessage = messageRepository.save(message);
        return messageMapper.toMessageResponse(saveMessage);
    }

    @Override
    public MessageResponse update(Integer id, MessageRequest messageRequest) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("LESSON", id));

        messageMapper.updateFromMessageRequest(messageRequest, existingMessage);
        Message updateMessage = messageRepository.save(existingMessage);
        return messageMapper.toMessageResponse(updateMessage);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Page<MessageResponse> getAll(Pageable pageable) {
        Page<Message> messagePage = messageRepository.findAll(pageable);
        return messagePage.map(messageMapper::toMessageResponse);
    }

    @Override
    public Optional<MessageResponse> getById(Integer id) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isEmpty()) throw new IdNotFoundException("LESSON", id);
        return message.map(messageMapper::toMessageResponse);
    }
}
