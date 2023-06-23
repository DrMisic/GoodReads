package com.example.webProj.controller;

import com.example.webProj.dto.PolicaDto;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@CrossOrigin
@RestController
public class PolicaController {
    private final PolicaService policaService;
    @Autowired
    public PolicaController(PolicaService policaService) {
        this.policaService = policaService;
    }
    @GetMapping(path = "/api/police")
    public List<Polica> getPolice(){return policaService.findAll();}
    @GetMapping(path = "/api/polica/id/{id}")
    public Polica getPolicaById(@PathVariable("id") Long id){return policaService.findOne(id);}
    @GetMapping(path = "/api/polica/naziv/{naziv}")
    public Polica getPolicaByNaziv(@PathVariable("naziv") String naziv){return policaService.findPolicaByNaziv(naziv);}
    @PostMapping(path = "/api/save-polica")
    public ResponseEntity<String> savePolica(@RequestBody  PolicaDto policaDto, HttpSession session){

        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest == null)
        {
            return new ResponseEntity("Nisi ulogovan", HttpStatus.UNAUTHORIZED);
        }
        for(Polica p : korisnikTest.getPolica())
        {
            if(p.getNaziv().equals(policaDto.getNaziv()) )
            {
                return new ResponseEntity("Već postoji polica sa tim imenom", HttpStatus.CONFLICT);
            }
        }
        Polica polica = new Polica(policaDto.getNaziv(), false);
        Set<Polica> police = korisnikTest.getPolica();
        police.add(polica);
        korisnikTest.setPolica(police);

        this.policaService.save(polica);
        return new ResponseEntity("Uspješno sačuvana polica", HttpStatus.OK);
    }




}
