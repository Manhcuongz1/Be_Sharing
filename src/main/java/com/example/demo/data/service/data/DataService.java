package com.example.demo.data.service.data;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DataService {

    ResponseEntity<?> insertData(List<MultipartFile> file, String idPhone, String path);
    ResponseEntity<?> getUrlPostFile(String idPhone);
    ResponseEntity<?> getDataByUrl();
    ResponseEntity<?> deleteData(String url, String idPhone);
    ResponseEntity<?> getAll();

}
