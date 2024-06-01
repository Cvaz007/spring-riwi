package com.example.demo.infraestructure.services;

import com.example.demo.api.dto.request.create.FileRequest;
import com.example.demo.api.dto.request.update.FileUpdateRequest;
import com.example.demo.api.dto.response.FileResponse;
import com.example.demo.domain.entities.File;
import com.example.demo.domain.entities.Project;
import com.example.demo.domain.repositories.FileRepository;
import com.example.demo.domain.repositories.ProjectRepository;
import com.example.demo.infraestructure.abstract_services.IFileService;
import com.example.demo.infraestructure.mappers.FileMapper;
import com.example.demo.util.exeptions.IdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FileService implements IFileService {
    @Autowired
    private final FileRepository fileRepository;
    @Autowired
    private final FileMapper fileMapper;
    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public FileResponse create(FileRequest fileRequest) {
        File file = fileMapper.toFile(fileRequest);
        /*Project project = projectRepository.findById(fileRequest.getProjectId())
                .orElseThrow(() -> new IdNotFoundException("PROJECT", fileRequest.getProjectId()));*/

//        file.setProjectId(project);
        File saveFile = fileRepository.save(file);
        return fileMapper.toFileResponse(saveFile);
    }

    @Override
    public FileResponse update(Long id, FileUpdateRequest fileRequest) {
        File existingFile = fileRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("ASSIGNMENT", id));

        fileMapper.updateFromFileRequest(fileRequest, existingFile);
        File updateFile = fileRepository.save(existingFile);
        return fileMapper.toFileResponse(updateFile);
    }

    @Override
    public void delete(Long id) {
        fileRepository.deleteById(id);
    }

    @Override
    public Page<FileResponse> getAll(Pageable pageable) {
        Page<File> filePage = fileRepository.findAll(pageable);
        return filePage.map(fileMapper::toFileResponse);
    }

    @Override
    public Optional<FileResponse> getById(Long id) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isEmpty()) throw new IdNotFoundException("ASSIGNMENT", id);
        return file.map(fileMapper::toFileResponse);
    }

    @Override
    public void createFilesFromProject(List<FileRequest> files, Long projectId) {
        for (FileRequest fileRequest : files) {
            File file = fileMapper.toFile(fileRequest);
            file.setProjectId(projectRepository.findById(projectId)
                    .orElseThrow(() -> new IdNotFoundException("PROJECT", projectId)));
            fileRepository.save(file);
        }
    }
}
