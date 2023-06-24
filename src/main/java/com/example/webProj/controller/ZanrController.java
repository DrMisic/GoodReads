package com.example.webProj.controller;

import com.example.webProj.dto.ZanrDto;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Zanr;
import com.example.webProj.service.KorisnikService;
import com.example.webProj.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ZanrController {

    private final ZanrService zanrService;
    private final KorisnikService korisnikService;
    @Autowired
    public ZanrController(ZanrService zanrService,KorisnikService korisnikService) {
        this.zanrService = zanrService;
        this.korisnikService= korisnikService;
    }

    @GetMapping(path = "/api/zanrovi")
    public List<Zanr> getZanrovi(){return zanrService.findAll();}
    @GetMapping(path = "/api/zanr/{id}")
    public Zanr getZanr(@PathVariable("id")Long id){return zanrService.foundOne(id);}
    @GetMapping(path = "/api/zanr/{naslov}")
    public List<Zanr> getZanrByNaslov(@PathVariable("naslov") String naslov){return zanrService.findZanrByNaslov(naslov);}
    @PostMapping(path = "/api/add-new-zanr")
    public ResponseEntity<String> addNewZanr(@RequestBody ZanrDto zanrDto, HttpSession session){
        Korisnik loggedUser = (Korisnik) session.getAttribute("loggedUser");
        loggedUser = korisnikService.findOne(loggedUser.getId());
        if(loggedUser == null)
        {
            return new ResponseEntity<>("Nema sesije", HttpStatus.FORBIDDEN);
        }
        loggedUser = korisnikService.findOne(loggedUser.getId());

        if(!(loggedUser.getUloga()== Korisnik.Uloge.ADMINISTRATOR))
        {
            return new ResponseEntity<>("Niste administrator", HttpStatus.FORBIDDEN);
        }

        Zanr zanr = new Zanr();
        zanr.setNaslov(zanrDto.getNaslov());
        for(Zanr z:zanrService.findAll())
        {
            if(zanr.getNaslov().equals(z.getNaslov()))
            {
                return new ResponseEntity<>("Već postoji žanr", HttpStatus.BAD_REQUEST);
            }
        }
        this.zanrService.save(zanr);
        return new ResponseEntity<>("Uspješno sačuvan žanr", HttpStatus.OK);
    }
}
