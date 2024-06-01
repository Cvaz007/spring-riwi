package com.example.demo.api.dto.request.update;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileUpdateRequest {
    private String name;
    private String description;
}
