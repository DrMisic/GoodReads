package com.example.webProj.controller;

import com.example.webProj.entity.Polica;
import com.example.webProj.service.PolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PolicaController {
    private final PolicaService policaService;
    @Autowired
    public PolicaController(PolicaService policaService) {
        this.policaService = policaService;
    }
    @GetMapping(path = "/api/police")
    public List<Polica> getPolice(){return policaService.findAll();}
    @GetMapping(path = "/api/polica/{id}")
    public Polica getPolicaById(@PathVariable("id") Long id){return policaService.findOne(id);}
    @GetMapping(path = "/api/polica/{naziv}")
    public Polica getPolicaByNaziv(@PathVariable("naziv") String naziv){return policaService.findPolicaByNaziv(naziv);}
    @PostMapping(path = "/api/save-polica")
    public String savePolica(Polica polica){
        this.policaService.save(polica);
        return "Uspješno sačuvana polica";
    }


}
