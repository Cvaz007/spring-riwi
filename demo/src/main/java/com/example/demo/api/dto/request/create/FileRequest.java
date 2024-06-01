package com.example.demo.api.dto.request.create;

import com.example.demo.api.dto.request.update.FileUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileRequest extends FileUpdateRequest {
    private String type;
}
