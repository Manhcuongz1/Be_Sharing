package com.example.demo.database.Service.storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {
    public void uploadFile(MultipartFile file, Path path);
    public List<MultipartFile> getAllFile(List<MultipartFile> file);
    public void deleteAllFile(List<MultipartFile> file);

}
