package com.example.webProj.service;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StavkaPoliceService {
    @Autowired
    public StavkaPoliceRepository stavkaPoliceRepository;

    public StavkaPolice foundOne(Long id)
    {
        Optional<StavkaPolice> foundStavkaPolice = stavkaPoliceRepository.findById(id);
        if(foundStavkaPolice.isPresent())
        {
            return foundStavkaPolice.get();
        }

        return null;
    }

    public List<StavkaPolice> findAll(){return stavkaPoliceRepository.findAll();}
    public List<StavkaPolice> findStavkaPoliceByKnjiga(Knjiga knjiga){return stavkaPoliceRepository.getStavkaPoliceByKnjiga(knjiga);}
    public StavkaPolice  save(StavkaPolice stavkaPolice){return stavkaPoliceRepository.save(stavkaPolice);}
}
