package com.example.webProj.service;

import com.example.webProj.dto.AutorDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutorService {
    @Autowired
    private  AutorRepository autorRepository;

    public Autor findOne(Long id)
    {
        Optional<Autor> foundAutor = autorRepository.findById(id);
        if(foundAutor.isPresent())
        {
            return foundAutor.get();
        }

        return null;
    }

    public List<Autor> findAllByIme(String Ime)
    {
        return autorRepository.findAllByIme(Ime);
    }
    public List<Autor> findAllByIsActive(boolean isAktivan)
    {
        return autorRepository.findAllByAktivan(isAktivan);
    }

    public List<Autor> findAllByPrezime(String Prezime)
    {
        return autorRepository.findAllByPrezime(Prezime);
    }

    public List<Autor> findAll(){return autorRepository.findAll();}

    public Autor save(Autor autor){return autorRepository.save(autor);}

    public Autor updateUser(Long id, AutorDto autorDto){
        Autor a = findOne(id);



        a.setIme(autorDto.getIme());
        a.setPrezime(autorDto.getPrezime());
        a.setProfilna_slika(autorDto.getProfilna_slika());
        a.setDatum_rodjenja(autorDto.getDatum_rodjenja());
        a.setOpis(autorDto.getOpis());
        a.setUloga(Korisnik.Uloge.AUTOR);
        Polica primarnaPolicaWantToRead = new Polica("Want to read",true);
        Polica primarnaPolicaCurrentlyReading = new Polica("Currently reading",true);
        Polica primarnaPolicaRead = new Polica("Read",true);
        Set<Polica> police = new HashSet<>();
        police.add(primarnaPolicaWantToRead);
        police.add(primarnaPolicaCurrentlyReading);
        police.add(primarnaPolicaRead);
        a.setPolica(police);



        if(a.getLozinka() != null && !autorDto.getLozinka().isEmpty()) {

            a.setLozinka(autorDto.getLozinka());
        }

        if(a.getEmail() != null && !autorDto.getEmail().isEmpty()){

            a.setEmail(autorDto.getEmail());
        }

        return save(a);
    }
}
