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
    private Integer senderId;
    private Integer receiverId;
    private Integer courseId;
    private String messageContent;
    private Date sentDate;
}
