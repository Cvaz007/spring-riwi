package com.example.demo.infraestructure.abstract_services;

import com.example.demo.api.dto.request.create.FileRequest;
import com.example.demo.api.dto.request.update.FileUpdateRequest;
import com.example.demo.api.dto.response.FileResponse;

import java.util.List;

public interface IFileService extends
        CreateReadDeleteService<FileRequest, FileResponse, Long>,
        UpdateService<FileUpdateRequest, FileResponse, Long>
{
    void createFilesFromProject(List<FileRequest> files, Long projectId);
}
