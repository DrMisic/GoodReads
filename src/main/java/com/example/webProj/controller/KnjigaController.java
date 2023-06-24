package com.example.webProj.controller;

import com.example.webProj.dto.KnjigaDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Zanr;
import com.example.webProj.service.KnjigaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Date;
import java.util.List;
import java.util.Set;
@CrossOrigin
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
    @GetMapping(path = "/api/knjiga/id/{id}")
    public Knjiga getKnjiga(@PathVariable(name = "id") Long id) {
        return knjigaService.findOne(id);
    }

    @DeleteMapping("/api/admin/{knjigaId}")
    public ResponseEntity<?> deleteKnjigaAdmin(@PathVariable Long knjigaId, HttpSession session) throws ChangeSetPersister.NotFoundException {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("employee");
        if(loggedKorisnik.getUloga() == Korisnik.Uloge.ADMINISTRATOR){
            knjigaService.deleteKnjigaAdmin(knjigaId);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("You are not administrator", HttpStatus.OK);
        }
    }
    @GetMapping(path = "/api/knjiga/naslov/{naslov}")
    public Knjiga getOneByNaslov(@PathVariable("naslov") String naslov) {
        return knjigaService.findOneByNaslov(naslov);
    }
    @GetMapping(path = "/api/knjiga/isbn/{ISBN}")
    public List<Knjiga> getAllByISBN(@PathVariable("ISBN") double ISBN) {
        return knjigaService.findAllByISBN(ISBN);
    }
    @GetMapping(path = "/api/knjiga/{datumObjavljivanja}")
    public List<Knjiga> getAllByDatumObjavljivanja(@PathVariable("datumObjavljivanja") Date datumObjavljivanja) {
        return knjigaService.findAllByDatumObjavljivanja(datumObjavljivanja);
    }
    @GetMapping(path = "/api/knjiga/zanr/{zanr}")
    public List<Knjiga> getAllByZanr(@PathVariable("zanr") Zanr zanr) {
        return knjigaService.findAllByZanr(zanr);
    }
    @GetMapping(path = "/api/knjiga/{ocena}")
    public List<Knjiga> getAllByOcena(@PathVariable("ocena") double ocena) {
        return knjigaService.findAllByOcena(ocena);
    }







}
