package com.example.demo.api.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUpdateRequest {
    private String name;
    private String description;
    private Date endDate;
}
