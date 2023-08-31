package com.example.demo.controller;

import com.example.demo.Constant;
import com.example.demo.database.Service.Data.DataServiceImp;
import com.example.demo.database.Service.Link.LinkServiceImp;
import com.example.demo.database.Service.storage.Path;
import com.example.demo.database.Service.storage.StorageServiceImp;
import com.example.demo.database.entity.LinkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class Controller {

    @Autowired
    private StorageServiceImp storageServiceImp;
    @Autowired
    private LinkServiceImp linkServiceImp;
    @Autowired
    DataServiceImp dataServiceImp;

    @PostMapping(value = "/upload", consumes ="multipart/form-data" )
    public String upLoadMedia(@RequestParam List<MultipartFile> file) {
        LinkEntity link = new LinkEntity();
        Path path = new Path();
        link.setUrl(path.getPath());
        link.setDate(new Date());

        linkServiceImp.Create(link);
        for(int i=0; i<file.size(); i++) {
            storageServiceImp.uploadFile(file.get(i), path);
            dataServiceImp.CreateByPath(file.get(i),path,link);
        }
        return "OKE";
    }
  //  @GetMapping(value = "/get")
//    @GetMapping("/download/${id}")
//    public String download(@PathVariable String value) {
//
//    }
}
