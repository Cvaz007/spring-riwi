package com.example.demo.api.dto.response;

import com.example.demo.domain.entities.Project;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    private Long id;
    private String name;
    private String description;
    private String type;
    private ProjectResponse projectId;
}
