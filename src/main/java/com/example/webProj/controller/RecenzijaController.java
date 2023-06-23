package com.example.webProj.controller;

import com.example.webProj.dto.KnjigaDto;
import com.example.webProj.dto.RecenzijaDto;
import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Recenzija;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.service.KnjigaService;
import com.example.webProj.service.RecenzijaService;
import com.example.webProj.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController
public class RecenzijaController {
    public final RecenzijaService recenzijaService;
    public final StavkaPoliceService stavkaPoliceService;
    public final KnjigaService knjigaService;
    @Autowired
    public RecenzijaController(RecenzijaService recenzijaService,StavkaPoliceService stavkaPoliceService, KnjigaService knjigaService) {
        this.recenzijaService = recenzijaService;
        this.stavkaPoliceService =stavkaPoliceService;
        this.knjigaService = knjigaService;
    }

    @GetMapping(path ="/api/recenzije")
    public List<Recenzija> getRecenzije(){return recenzijaService.findAll();}
    @GetMapping(path = "/api/recenzija/knjiga/{knjiga}")
    public Set<Recenzija> getRecenzijaByKnjiga(@PathVariable("knjiga") String naslovKnjige)
    {
        Set<Recenzija> lista = new HashSet<>();
        StavkaPolice stavka = new StavkaPolice();
        Knjiga knjiga = knjigaService.findOneByNaslov(naslovKnjige);
        if(knjiga == null)
        {
            return null;
        }
        stavka = stavkaPoliceService.findStavkaPoliceByKnjiga(knjiga);
        lista =  stavka.getRecenzija();
        return lista;

    }
    @GetMapping(path = "/api/recenzija/id/{id}")
    public Recenzija getRecenzijaById(@PathVariable("id")Long id){return recenzijaService.findOne(id);}
    @GetMapping(path = "/api/recenizija/korisnik/{korisnik}")
    public List<Recenzija> getRecenzijaByKorisnik(@PathVariable("korisnik")Korisnik korisnik){return recenzijaService.findRecenzijaByKorisnik(korisnik);}
    @GetMapping(path = "/api/recenzija/datum_recenzije/{datumRecenzije}")
    public List<Recenzija> getRecenzijaByDatumRecenzije(@PathVariable("datumRecenzije")Date datumRecenzije){return recenzijaService.findRecenzijaByDatumRecenzije(datumRecenzije);}
    @PostMapping(path = "/api/save-recenzija")
    public ResponseEntity<String> saveRecenizja(@RequestBody RecenzijaDto recenzija, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("loggedUser");
        if(loggedUser == null)
        {
            return new ResponseEntity<>("Nema sesije", HttpStatus.FORBIDDEN);
        }
        Recenzija rec = new Recenzija();
        rec.setKorisnik(loggedUser);
        rec.setOcena(recenzija.getOcena());
        rec.setTekst(recenzija.getTekst());
        java.util.Date currentDate = new java.util.Date();
        rec.setDatum_recenzije(currentDate);

        this.recenzijaService.save(rec);
        return  new ResponseEntity<>("Uspješno sačuvana recenzija", HttpStatus.OK);
    }
    @PutMapping(path="/api/update-recenzija/{id}")
    public ResponseEntity<String> updateRecenzija(@RequestBody RecenzijaDto recenzijaDto,@PathVariable("id")Long id,HttpSession session)
    {
        Korisnik loggedUser = (Korisnik) session.getAttribute("loggedUser");
        if(loggedUser == null)
        {
            return new ResponseEntity<>("Nema sesije", HttpStatus.FORBIDDEN);
        }
        Recenzija rec = recenzijaService.findOne(id);
        if(rec == null)
        {
            return new ResponseEntity<>("Ne postoji ta recenzija", HttpStatus.FORBIDDEN);
        }

        if(!rec.getKorisnik().getKorisnicko_ime().equals(loggedUser.getKorisnicko_ime()))
        {
            return  new ResponseEntity<>("Ne možete da mijenjate tuđe recenzije"+loggedUser.getKorisnicko_ime()+" "+rec.getKorisnik().getKorisnicko_ime(), HttpStatus.UNAUTHORIZED);
        }

        rec.setTekst(recenzijaDto.getTekst());
        rec.setOcena(recenzijaDto.getOcena());
        java.util.Date currentDate = new java.util.Date();
        rec.setDatum_recenzije(currentDate);
        this.recenzijaService.save(rec);
        return  new ResponseEntity<>("Uspješno ažurirana recenzija", HttpStatus.OK);
    }
}
