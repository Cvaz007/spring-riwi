package com.example.demo.infraestructure.mappers;

import com.example.demo.api.dto.request.create.FileRequest;
import com.example.demo.api.dto.request.update.FileUpdateRequest;
import com.example.demo.api.dto.response.FileResponse;
import com.example.demo.domain.entities.File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mapping(target = "id", ignore = true)
    File toFile(FileRequest fileRequest);

    FileResponse toFileResponse(File file);

    void updateFromFileRequest(FileUpdateRequest fileRequest, @MappingTarget File file);
}
