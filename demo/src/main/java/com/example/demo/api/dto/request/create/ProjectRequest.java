package com.example.demo.api.dto.request.create;

import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest extends ProjectUpdateRequest {
    private Date startDate;
}
