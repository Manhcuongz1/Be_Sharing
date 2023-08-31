package com.example.demo.database.Service.storage;


import com.example.demo.database.Service.StorageException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class StorageServiceImp implements StorageService {
    private String path;
    public void uploadFile(MultipartFile file, Path path) {
        this.path = path.getPath();
        if (file.isEmpty()) {
            throw new StorageException("file rỗng");
        } else {
            try {
                // lấy tên gốc của file
                String fileName = file.getOriginalFilename();
                InputStream is = file.getInputStream();
                // tạo folder nếu chưa tồn tại
                Files.createDirectories(Paths.get(this.path));
                // ghi file vào vị trí filepath

                Files.copy(is, Paths.get(this.path + fileName), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File saved successfully: " + this.path + fileName);
            } catch (IOException e) {
                String msg = String.format("Failed to store file %s", file.getName());
                throw new StorageException(msg, e);
            }
        }
    }

    @Override
    public List<MultipartFile> getAllFile(List<MultipartFile> file) {
        return null;
    }

    @Override
    public void deleteAllFile(List<MultipartFile> file) {

    }


}
