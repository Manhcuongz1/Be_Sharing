package com.example.demo.data.service.storage;

import com.example.demo.data.response.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {
    public Response<?> readFileToStorage(List<MultipartFile> file, String path);
    public List<MultipartFile> getAllFile(List<MultipartFile> file);
    public void deleteAllFile(List<MultipartFile> file);

}
