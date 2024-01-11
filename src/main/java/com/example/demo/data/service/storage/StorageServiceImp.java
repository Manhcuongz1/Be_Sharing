package com.example.demo.data.service.storage;


import com.example.demo.exception.StorageException;
import com.example.demo.data.response.MessageResponse;
import com.example.demo.data.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class StorageServiceImp implements StorageService {
    String uriWriteFile ="";
    public Response<?> readFileToStorage(List<MultipartFile> listFile, String path) {
        uriWriteFile = RandomPath.getInstance().buildPath(path);
        if (listFile.isEmpty()) {
            throw new StorageException("listFile rỗng");
        } else {
            for (MultipartFile file : listFile) {
                try {
                    InputStream is = file.getInputStream();
                    // tạo folder nếu chưa tồn tại
                    Files.createDirectories(Paths.get(uriWriteFile));

                    // Tạo đường dẫn đầy đủ cho file đích
                    Path filePath = Paths.get(uriWriteFile, file.getOriginalFilename());

                    // ghi listFile vào vị trí filepath
                    Files.copy(is, filePath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File saved successfully: " + uriWriteFile + file.getOriginalFilename());
                } catch (IOException e) {
                    String msg = String.format("Failed to store File %s", file.getName());
                    System.out.println(msg);
                    throw new StorageException(MessageResponse.ERROR_WRITE_FILE);
                }
            }
        }

        return new Response<>(null, MessageResponse.SUCCESS_FILE, Boolean.TRUE, null);
    }

    @Override
    public List<MultipartFile> getAllFile(List<MultipartFile> file) {
        return null;
    }

    @Override
    public void deleteAllFile(List<MultipartFile> file) {

    }


}
