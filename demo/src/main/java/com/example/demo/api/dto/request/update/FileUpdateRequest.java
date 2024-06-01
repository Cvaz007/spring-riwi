package com.example.demo.api.dto.request.update;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FileUpdateRequest {
    private String name;
    private String description;
}
