package com.example.webProj.controller;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Zanr;
import com.example.webProj.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
public class KnjigaController {
    private final KnjigaService knjigaService;
    @Autowired
    public KnjigaController(KnjigaService knjigaService) {
        this.knjigaService = knjigaService;
    }

    @GetMapping(path = "/api/knjige")
    public List<Knjiga> getKnjige() {
        return knjigaService.findAll();
    }
    @GetMapping(path = "/api/knjiga/{id}")
    public Knjiga getKnjiga(@PathVariable(name = "id") Long id) {
        return knjigaService.findOne(id);
    }
    @GetMapping(path = "/api/knjiga/{naslov}")
    public List<Knjiga> getAllByNaslov(@PathVariable("naslov") String naslov) {
        return knjigaService.findAllByNaslov(naslov);
    }
    @GetMapping(path = "/api/knjiga/{ISBN}")
    public List<Knjiga> getAllByISBN(@PathVariable("ISBN") double ISBN) {
        return knjigaService.findAllByISBN(ISBN);
    }
    @GetMapping(path = "/api/knjiga/{datumObjavljivanja}")
    public List<Knjiga> getAllByDatumObjavljivanja(@PathVariable("datumObjavljivanja") Date datumObjavljivanja) {
        return knjigaService.findAllByDatumObjavljivanja(datumObjavljivanja);
    }
    @GetMapping(path = "/api/knjiga/{zanr}")
    public List<Knjiga> getAllByZanr(@PathVariable("zanr") Zanr zanr) {
        return knjigaService.findAllByZanr(zanr);
    }
    @GetMapping(path = "/api/knjiga/{ocena}")
    public List<Knjiga> getAllByOcena(@PathVariable("ocena") double ocena) {
        return knjigaService.findAllByOcena(ocena);
    }
    @PostMapping(path="/api/save-knjiga")
    public String saveKnjiga(@RequestBody Knjiga knjiga)
    {
        this.knjigaService.save(knjiga);
        return "Uspješno sačuvana knjiga";
    }






}
