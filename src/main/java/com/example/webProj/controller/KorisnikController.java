package com.example.webProj.controller;

import com.example.webProj.dto.KorisnikDto;
import com.example.webProj.dto.LoginDto;
import com.example.webProj.dto.SignUpDto;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KorisnikController {
    private final KorisnikService korisnikService;
    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
    @PostMapping(path="/api/save-korisnik")
    public String saveKorisnik(Korisnik korisnik){
        this.korisnikService.save(korisnik);
        return "Korisnik uspješno sačuvan";
    }
    @PostMapping(path = "/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session)
    {
        if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
        {
            return new ResponseEntity("Email ili lozinka su prazni.", HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik = korisnikService.findKorisnikByEmail(loginDto.getEmail());
        if(korisnik == null)
        {
            return new ResponseEntity("Korisnik ne postoji",HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("korisnik",korisnik);
        return ResponseEntity.ok("Uspješno prijavljen");
    }
    @PostMapping(path="/api/register")
    public ResponseEntity<String> register(@RequestBody SignUpDto signUpDto,HttpSession session)
    {
        if(     signUpDto.getIme().isEmpty() ||
                signUpDto.getKorisnickoIme().isEmpty() ||
                signUpDto.getLozinka().isEmpty() ||
                signUpDto.getEmail().isEmpty() ||
                signUpDto.getLozinkaDrugiPut().isEmpty() ||
                signUpDto.getPrezime().isEmpty())
        {
            return new ResponseEntity("Unesite sve podatke potrebne za registraciju",HttpStatus.BAD_REQUEST);
        }

        if(!signUpDto.getLozinka().equals(signUpDto.getLozinkaDrugiPut()))
        {
            return new ResponseEntity("Lozinke se ne poklapaju",HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik = korisnikService.findKorisnikByEmail(signUpDto.getEmail());
        if(korisnik != null)
        {
            return new ResponseEntity("Email je zauzet",HttpStatus.CONFLICT);
        }
        korisnik = korisnikService.findKorisnikByKorisnickoIme(signUpDto.getKorisnickoIme());
        if(korisnik !=null)
        {
            return new ResponseEntity("Korisnicko ime je zauzeto",HttpStatus.CONFLICT);
        }
        session.setAttribute("korisnik",korisnik);
        //saveKorisnik(korisnik);
        //this.korisnikService.save(korisnik);
        return ResponseEntity.ok("Uspješno registrovan");
    }
    @GetMapping(path = "/api/korisnici")
    public List<Korisnik> getKorisnici() {return korisnikService.findAll();}
    @GetMapping(path = "/api/korisnik/{id}")
    public Korisnik getKorisnikById(@PathVariable(name = "id") Long id){return korisnikService.findOne(id);}
    @GetMapping(path = "/api/korisnik/{korisnickoIme}")
    public Korisnik getKorisnikByKorisnickoIme(@PathVariable("korisnickoIme") String korisnickoIme){return korisnikService.findKorisnikByKorisnickoIme(korisnickoIme);}
    @GetMapping(path = "/api/korisnik/{email}")
    public Korisnik getKorisnikByEmail(@PathVariable("email") String email){return korisnikService.findKorisnikByEmail(email);}
    @GetMapping(path = "/api/korisnik/{uloga}")
    public List<Korisnik> getAllByUloga(@PathVariable("uloga")Korisnik.Uloge uloga){return korisnikService.findAllByUloga(uloga);}

}
