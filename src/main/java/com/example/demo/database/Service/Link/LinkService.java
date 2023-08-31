package com.example.demo.database.Service.Link;

import com.example.demo.database.entity.LinkEntity;

public interface LinkService{
    LinkEntity Create(LinkEntity link);
    void Delete(Long id);
    LinkEntity FindById(Long id);
}
