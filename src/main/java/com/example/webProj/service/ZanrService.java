package com.example.webProj.service;

import com.example.webProj.entity.Zanr;
import com.example.webProj.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {
    @Autowired
    public ZanrRepository zanrRepository;

    public Zanr foundOne(Long id)
    {
        Optional<Zanr> foundZanr = zanrRepository.findById(id);
        if(foundZanr.isPresent())
        {
            return foundZanr.get();
        }
        return null;
    }

    public List<Zanr> findZanrByNaslov(String naslov){return zanrRepository.getZanrByNaslov(naslov);}
    public List<Zanr> findAll(){return zanrRepository.findAll();}
    public Zanr save(Zanr zanr){return zanrRepository.save(zanr);}

}
