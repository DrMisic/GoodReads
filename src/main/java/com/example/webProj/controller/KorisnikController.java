package com.example.webProj.controller;

import com.example.webProj.dto.KorisnikDto;
import com.example.webProj.dto.LoginDto;
import com.example.webProj.dto.SignUpDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.service.KorisnikService;
import com.example.webProj.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class KorisnikController {
    private final KorisnikService korisnikService;
    private final PolicaService policaService;
    @Autowired
    public KorisnikController(KorisnikService korisnikService, PolicaService policaService) {
        this.korisnikService = korisnikService;
        this.policaService = policaService;
    }
    @PostMapping(path="/api/save-korisnik")
    public String saveKorisnik(Korisnik korisnik){
        this.korisnikService.save(korisnik);
        return "Korisnik uspješno sačuvan";
    }
    @PostMapping(path = "/api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session)
    {
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest != null)
        {
            if(korisnikTest.getEmail().equals(loginDto.getEmail())) {
                return new ResponseEntity("Vec si ulogovan.", HttpStatus.BAD_REQUEST);
            }
        }
        if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
        {
            return new ResponseEntity("Email ili lozinka su prazni.", HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik = korisnikService.findKorisnikByEmail(loginDto.getEmail());
        if(korisnik == null)
        {
            return new ResponseEntity("Korisnik ne postoji",HttpStatus.BAD_REQUEST);
        }

        if(!korisnik.getLozinka().equals(loginDto.getPassword()))
        {
            return new ResponseEntity("Pogrešna lozinka",HttpStatus.UNAUTHORIZED);
        }
        session.setAttribute("loggedUser",korisnik);
        return ResponseEntity.ok("Uspješno prijavljen");
    }

    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("loggedUser");

        if (loggedKorisnik == null)
            return new ResponseEntity("Niste ni prijavljeni", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspješno izlogovan", HttpStatus.OK);
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
        Korisnik korisnikTest = korisnikService.findKorisnikByEmail(signUpDto.getEmail());
        if(korisnikTest != null)
        {
            return new ResponseEntity("Email je zauzet",HttpStatus.CONFLICT);
        }
        korisnikTest = korisnikService.findKorisnikByKorisnickoIme(signUpDto.getKorisnickoIme());
        if(korisnikTest !=null)
        {
            return new ResponseEntity("Korisnicko ime je zauzeto",HttpStatus.CONFLICT);
        }
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(signUpDto.getIme());
        korisnik.setPrezime(signUpDto.getPrezime());
        korisnik.setEmail(signUpDto.getEmail());
        korisnik.setKorisnicko_ime(signUpDto.getKorisnickoIme());
        korisnik.setLozinka(signUpDto.getLozinka());
        korisnik.setUloga(Korisnik.Uloge.CITALAC);
        Polica primarnaPolicaWantToRead = new Polica("Want to read",true);
        Polica primarnaPolicaCurrentlyReading = new Polica("Currently reading",true);
        Polica primarnaPolicaRead = new Polica("Read",true);
        Set<Polica> police = new HashSet<>();
        police.add(primarnaPolicaWantToRead);
        police.add(primarnaPolicaCurrentlyReading);
        police.add(primarnaPolicaRead);
        korisnik.setPolica(police);

        session.setAttribute("registeredUser",korisnik);
        //saveKorisnik(korisnik);
        this.korisnikService.save(korisnik);
        return ResponseEntity.ok("Uspješno registrovan");
    }
    @GetMapping(path = "/api/korisnici")
    public List<Korisnik> getKorisnici() {return korisnikService.findAll();}
    @GetMapping(path = "/api/korisnik/id/{id}")
    public Korisnik getKorisnikById(@PathVariable(name = "id") Long id){return korisnikService.findOne(id);}
    @GetMapping(path = "/api/korisnik/polica/{id}")
    public Polica getKorisnikovaPolicaById(@PathVariable(name = "id")Long id,HttpSession session)
    {

        Korisnik k = (Korisnik) session.getAttribute("loggedUser");
        if(k == null)
        {
            return null;
        }
        for(Polica p : k.getPolica())
        {
            if(p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }
    @GetMapping(path = "/api/korisnik/korisnickoIme/{korisnickoIme}")
    public Korisnik getKorisnikByKorisnickoIme(@PathVariable("korisnickoIme") String korisnickoIme){return korisnikService.findKorisnikByKorisnickoIme(korisnickoIme);}
    @GetMapping(path = "/api/korisnik/{email}")
    public Korisnik getKorisnikByEmail(@PathVariable("email") String email){return korisnikService.findKorisnikByEmail(email);}
    @GetMapping(path = "/api/korisnik/{uloga}")
    public List<Korisnik> getAllByUloga(@PathVariable("uloga")Korisnik.Uloge uloga){return korisnikService.findAllByUloga(uloga);}
    @PutMapping(path = "/api/update-korisnik")
    public ResponseEntity<String> update(@RequestBody KorisnikDto korisnikDto,HttpSession session)
    {
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest == null)
        {
                return new ResponseEntity("Nisi ulogovan.", HttpStatus.BAD_REQUEST);

        }
        korisnikTest.setIme(korisnikDto.getIme());
        korisnikTest.setPrezime(korisnikDto.getPrezime());
        korisnikTest.setLozinka(korisnikDto.getLozinka());
        korisnikTest.setEmail(korisnikDto.getEmail());
        korisnikTest.setKorisnicko_ime(korisnikDto.getKorisnicko_ime());
        korisnikTest.setOpis(korisnikDto.getOpis());
        korisnikTest.setDatum_rodjenja(korisnikDto.getDatum_rodjenja());
        korisnikTest.setProfilna_slika(korisnikDto.getProfilna_slika());
        return new ResponseEntity("Uspješno ažuriran.", HttpStatus.OK);
    }

}
