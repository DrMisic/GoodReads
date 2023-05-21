package com.example.webProj.service;

import com.example.webProj.entity.Autor;
import com.example.webProj.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
