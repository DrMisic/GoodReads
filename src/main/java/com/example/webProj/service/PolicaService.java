package com.example.webProj.service;

import com.example.webProj.entity.Polica;
import com.example.webProj.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
    public Polica findOne(Long id)
    {
        Optional<Polica> foundPolica = policaRepository.findById(id);
        if(foundPolica.isPresent())
        {
            return foundPolica.get();
        }
        return null;
    }

    public List<Polica> findAll(){return policaRepository.findAll();}
    public Polica findPolicaByNaziv(String naziv){return policaRepository.findPolicaByNaziv(naziv);}
    public Polica save(Polica polica){return policaRepository.save(polica);}
}
