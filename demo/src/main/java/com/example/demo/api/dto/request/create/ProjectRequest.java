package com.example.demo.api.dto.request.create;

import com.example.demo.api.dto.request.update.ProjectUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest extends ProjectUpdateRequest {
    private Date startDate;
    private List<FileRequest> files;
}
