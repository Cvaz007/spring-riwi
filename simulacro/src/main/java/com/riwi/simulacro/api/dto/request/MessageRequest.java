package com.riwi.simulacro.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private Long senderId;
    private Long receiverId;
    private Long courseId;
    private String messageContent;
    private Date sentDate;
}
