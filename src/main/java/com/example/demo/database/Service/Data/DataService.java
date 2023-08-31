package com.example.demo.database.Service.Data;

import com.example.demo.database.Service.storage.Path;
import com.example.demo.database.entity.DataEntity;
import com.example.demo.database.entity.LinkEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;


public interface DataService {

    void CreateByPath(MultipartFile file, Path path, LinkEntity link);
    void Delete(Long id);
    DataEntity FindById(Long id);
}
