package com.example.demo.data.service.data;

import com.example.demo.controller.ResponseUtil;
import com.example.demo.data.entity.DataEntity;
import com.example.demo.data.repository.DataRepository;
import com.example.demo.data.response.MessageResponse;
import com.example.demo.data.response.Response;
import com.example.demo.data.service.storage.RandomPath;
import com.example.demo.data.service.storage.StorageService;
import com.example.demo.extension.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImp implements DataService {
    @Autowired
    DataRepository dataRepository;
    @Autowired
    StorageService storageService;
    RandomPath randomPath = RandomPath.getInstance();


    @Override
    public ResponseEntity<?> insertData(List<MultipartFile> listFile, String idPhone, String folder) {
        DataEntity dataEntity = new DataEntity();
        List<String> fileName = new ArrayList<>();
        if (dataRepository.findByUrl(folder).size() !=0) {
            return ResponseUtil.error(HttpStatus.CONFLICT, new Response<>(null
                    , MessageResponse.ERROR_FOLDER_ALREADY_EXISTS,
                    false,
                    null));
        } else if (dataRepository.findByIdPhone(idPhone).size() >= 2) {
            return ResponseUtil.error(HttpStatus.CONFLICT, new Response<>(null,
                    MessageResponse.ERROR_ID_PHONE,
                    false,
                    null));
        } else if (!Format.checkStorage()) {
            return ResponseUtil.error(HttpStatus.CONFLICT, new Response<>(null,
                    MessageResponse.ERROR_OUT_OF_CAPACITY,
                    false,
                    null));
        } else {
            for (MultipartFile file : listFile) {
                fileName.add(file.getOriginalFilename());
            }
            dataEntity.setFileName(fileName);
            dataEntity.setIdPhone(idPhone);
            dataEntity.setDate(LocalDateTime.now());
            dataEntity.setUrl(folder);
            dataRepository.save(dataEntity);
        }
        return ResponseUtil.success(storageService.readFileToStorage(listFile, folder));
    }

    @Override
    public ResponseEntity<?> getUrlPostFile(String idPhone) {
        if (dataRepository.findByIdPhone(idPhone).size() > 2) {
            return ResponseUtil.error(HttpStatus.CONFLICT, MessageResponse.ERROR_ID_PHONE);
        }
        if (!Format.checkStorage()) {
            return ResponseUtil.error(HttpStatus.CONFLICT, new Response<>(false,
                    MessageResponse.ERROR_OUT_OF_CAPACITY,
                    false,
                    null));
        } else
            return ResponseUtil.success(new Response<>(null,
                    null,
                    Boolean.TRUE,
                    randomPath.create().getFolderName()));

    }

    @Override
    public ResponseEntity<?> getDataByUrl() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteData(String url, String idPhone) {
        DataEntity item = dataRepository.findDataEntitiesByUrl(url);
        if (item.getIdPhone().equals(idPhone)) {
            dataRepository.deleteById(item.getId());
            return ResponseUtil.success(new Response<>(null,
                    MessageResponse.DELETE_SUCCESS,
                    Boolean.TRUE,
                    null));
        }
        return ResponseUtil.error(HttpStatus.CONFLICT, new Response<>(null,
                MessageResponse.DELETE_ERROR,
                Boolean.FALSE,
                null));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }
}
