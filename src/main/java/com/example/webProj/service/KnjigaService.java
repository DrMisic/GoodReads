package com.example.webProj.service;


import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Zanr;
import com.example.webProj.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public Knjiga findOne(Long id)
    {
        Optional<Knjiga> foundKnjiga = knjigaRepository.findById(id);
        if(foundKnjiga.isPresent())
        {
            return foundKnjiga.get();
        }

        return null;
    }

    public List<Knjiga> findAllByNaslov(String naslov){return knjigaRepository.findAllByNaslov(naslov);}
    public List<Knjiga> findAllByISBN(double ISBN){return knjigaRepository.findAllByISBN(ISBN);}
    public List<Knjiga> findAllByDatumObjavljivanja (Date datum){return  knjigaRepository.findAllByDatumObjavljivanja(datum);}
    public List<Knjiga> findAllByZanr (Zanr zanr){return knjigaRepository.findAllByZanr(zanr);}
    public List<Knjiga> findAllByOcena (double ocena){return  knjigaRepository.findAllByOcena(ocena);}
    public List<Knjiga> findAll(){return knjigaRepository.findAll();}
    public Knjiga save(Knjiga knjiga){return knjigaRepository.save(knjiga);}



}
