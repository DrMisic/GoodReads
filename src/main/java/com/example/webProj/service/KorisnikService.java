package com.example.webProj.service;

import com.example.webProj.entity.Korisnik;
import com.example.webProj.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if(foundKorisnik.isPresent())
        {
            return foundKorisnik.get();
        }

        return null;
    }

    public Korisnik findKorisnikByKorisnickoIme(String korisnickoIme){return korisnikRepository.findKorisnikByKorisnickoIme(korisnickoIme);}
    public Korisnik findKorisnikByEmail(String email){return korisnikRepository.findKorisnikByEmail(email);}
    public List<Korisnik> findAllByUloga(Korisnik.Uloge uloga){return korisnikRepository.findAllByUloga(uloga);}
    public List<Korisnik> findAll(){return korisnikRepository.findAll();}
    public Korisnik save(Korisnik korisnik){return korisnikRepository.save(korisnik);}



}
