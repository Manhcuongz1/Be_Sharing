package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RestService
public interface Controller {

    @PostMapping(value = "/upload", consumes = "multipart/form-data", params = {"idPhone","folder"})
    @ResponseBody
    public ResponseEntity<?> postMedia(@RequestParam List<MultipartFile> file,
                                       @RequestParam String idPhone,
                                       @RequestParam String folder);

    @GetMapping(value = "/get_path", params = "idPhone")
    @ResponseBody
    public ResponseEntity<?> getUrlPostFile(String idPhone);

    @GetMapping(value = "/url", params = {"url", "idPhone"})
    public ResponseEntity<?> deleteUrl(@RequestParam String url, @RequestParam String idPhone);

    @GetMapping(value = "/download/folders", params = "path")
    public ResponseEntity<?> getAllFile(@RequestParam String path);
}
