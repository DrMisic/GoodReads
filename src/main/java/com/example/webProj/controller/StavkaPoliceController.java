package com.example.webProj.controller;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.service.KnjigaService;
import com.example.webProj.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StavkaPoliceController {
    public final StavkaPoliceService stavkaPoliceService;
    public final KnjigaService knjigaService;
    @Autowired
    public StavkaPoliceController(StavkaPoliceService stavkaPoliceService, KnjigaService knjigaService) {
        this.stavkaPoliceService = stavkaPoliceService;
        this.knjigaService = knjigaService;
    }

    @GetMapping(path = "/api/stavke_police")
    public List<StavkaPolice> getStavkePolice(){return stavkaPoliceService.findAll();}
    @GetMapping(path ="/api/stavka_police/{id}")
    public StavkaPolice getStavkaPolice(@PathVariable("id") Long id){return stavkaPoliceService.foundOne(id);}
    @GetMapping(path = "/api/stavka_police/{naslov_knjige}")
    public StavkaPolice getStavkaPoliceByKnjiga(@PathVariable("naslov_knjige")String naslovKnjige){

        return (StavkaPolice) stavkaPoliceService.findStavkaPoliceByKnjiga(knjigaService.findOneByNaslov(naslovKnjige));
    }/*
    @PostMapping(path =  "/api/save-stavka_police")
    public ResponseEntity<String> saveStavkaPolice(@RequestBody String naslov, HttpSession session)
    {
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest == null)
        {
            return new ResponseEntity("Nisi ulogovan", HttpStatus.UNAUTHORIZED);
        }
        for(Knjiga k: knjigaService.findAll())
        {
            if(k.getNaslov().equals(naslov))
            {
                Set<Polica> p = korisnikTest.getPolica();
                for(Polica pol: p)
                {

                }
            }
        }
        this.stavkaPoliceService.save(stavkaPolice);
        return new ResponseEntity("Uspješno sačuvana knjiga na polici", HttpStatus.OK);

    }
*/
}
