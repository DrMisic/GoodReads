package com.example.webProj.controller;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StavkaPoliceController {
    public final StavkaPoliceService stavkaPoliceService;
    @Autowired
    public StavkaPoliceController(StavkaPoliceService stavkaPoliceService) {
        this.stavkaPoliceService = stavkaPoliceService;
    }

    @GetMapping(path = "/api/stavke_police")
    public List<StavkaPolice> getStavkePolice(){return stavkaPoliceService.findAll();}
    @GetMapping(path ="/api/stavka_police/{id}")
    public StavkaPolice getStavkaPolice(@PathVariable("id") Long id){return stavkaPoliceService.foundOne(id);}
    @GetMapping(path = "/api/stavka_police/{knjiga}")
    public List<StavkaPolice> getStavkaPoliceByKnjiga(@PathVariable("knjiga")Knjiga knjiga){return stavkaPoliceService.findStavkaPoliceByKnjiga(knjiga);}
    @PostMapping(path =  "/api/save-stavka_police")
    public String saveStavkaPolice(StavkaPolice stavkaPolice)
    {
        this.stavkaPoliceService.save(stavkaPolice);
        return "Uspješno sačuvana stavka police";
    }

}
