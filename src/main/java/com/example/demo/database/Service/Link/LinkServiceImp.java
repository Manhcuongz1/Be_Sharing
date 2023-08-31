package com.example.demo.database.Service.Link;

import com.example.demo.database.entity.LinkEntity;
import com.example.demo.database.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements LinkService{
    @Autowired
    LinkRepository linkRepository;
    @Override
    public LinkEntity Create(LinkEntity link) {
        if(link.getUrl()== null || link.getUrl().isEmpty())
            return null;
        if(link.getDate() == null )
            return null;
        return linkRepository.save(link);
    }

    @Override
    public void Delete(Long id) {
        if(id!= null) {
            linkRepository.deleteById(id);
        }
    }

    @Override
    public LinkEntity FindById(Long id) {
        return linkRepository.findById(id).orElse(null);
    }
}
