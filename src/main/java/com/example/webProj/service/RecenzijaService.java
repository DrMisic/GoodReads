package com.example.webProj.service;

import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Recenzija;
import com.example.webProj.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {
    @Autowired
    public RecenzijaRepository recenzijaRepository;

    public Recenzija findOne(Long id)
    {
        Optional<Recenzija> foundRecenzija = recenzijaRepository.findById(id);
        if(foundRecenzija.isPresent())
        {
            return foundRecenzija.get();
        }
        return null;
    }

    public List<Recenzija> findAll(){return recenzijaRepository.findAll();}
    public List<Recenzija> findRecenzijaByKorisnik(Korisnik korisnik){return recenzijaRepository.getRecenzijaByKorisnik(korisnik);}
    public List<Recenzija> findRecenzijaByDatumRecenzije(Date datumRecenzije){return recenzijaRepository.getRecenzijaByDatumRecenzije(datumRecenzije);}
    public Recenzija save(Recenzija recenzija){return recenzijaRepository.save(recenzija);}

}
