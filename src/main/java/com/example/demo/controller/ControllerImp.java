package com.example.demo.controller;

import com.example.demo.data.service.data.DataServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestService
public class ControllerImp implements Controller {

    @Autowired
    DataServiceImp dataServiceImp;


    @Override
    public ResponseEntity<?> postMedia(List<MultipartFile> file, String idPhone, String folder) {
        return dataServiceImp.insertData(file,idPhone,folder);
    }
    public ResponseEntity<?>getUrlPostFile(String idPhone) {
        return dataServiceImp.getUrlPostFile(idPhone);
    }

    @Override
    public ResponseEntity<?> deleteUrl(String url, String idPhone) {
        return dataServiceImp.deleteData(url, idPhone);
    }

    @Override
    public ResponseEntity<?> getAllFile(String path) {
        return null;
    }

}
