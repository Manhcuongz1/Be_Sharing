package com.example.demo.database.Service.Data;

import com.example.demo.database.Service.storage.Path;
import com.example.demo.database.entity.DataEntity;
import com.example.demo.database.entity.LinkEntity;
import com.example.demo.database.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DataServiceImp implements DataService {
    @Autowired
    DataRepository dataRepository;
    @Override
    public void CreateByPath(MultipartFile file, Path path, LinkEntity idLink) {
        try {
            DataEntity dataEntity = new DataEntity();
            //ghi file path vào database
            String fileName = file.getOriginalFilename();
            dataEntity.setFilePath(path.getPath() + fileName);
            dataEntity.setLinkEntity(idLink);
            dataRepository.save(dataEntity);
        } catch (Exception e) {
        }

    }

    @Override
    public void Delete(Long id) {

    }

    @Override
    public DataEntity FindById(Long id) {
        return null;
    }
}
