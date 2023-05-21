package com.example.webProj.controller;

import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Recenzija;
import com.example.webProj.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RecenzijaController {
    public final RecenzijaService recenzijaService;
    @Autowired
    public RecenzijaController(RecenzijaService recenzijaService) {
        this.recenzijaService = recenzijaService;
    }

    @GetMapping(path ="/api/recenzije")
    public List<Recenzija> getRecenzije(){return recenzijaService.findAll();}
    @GetMapping(path = "/api/recenzija/{id}")
    public Recenzija getRecenzijaById(@PathVariable("id")Long id){return recenzijaService.findOne(id);}
    @GetMapping(path = "/api/recenizija/{korisnik}")
    public List<Recenzija> getRecenzijaByKorisnik(@PathVariable("korisnik")Korisnik korisnik){return recenzijaService.findRecenzijaByKorisnik(korisnik);}
    @GetMapping(path = "/api/recenzija/{datumRecenzije}")
    public List<Recenzija> getRecenzijaByDatumRecenzije(@PathVariable("datumRecenzije")Date datumRecenzije){return recenzijaService.findRecenzijaByDatumRecenzije(datumRecenzije);}
    @PostMapping(path = "/api/save-recenzija")
    public String saveRecenizja(Recenzija recenzija){
        this.recenzijaService.save(recenzija);
        return "Uspješno sačuvana recenzija";
    }
}
