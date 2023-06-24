package com.example.webProj.controller;

import com.example.webProj.dto.*;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.service.AutorService;
import com.example.webProj.service.KnjigaService;
import com.example.webProj.service.KorisnikService;
import com.example.webProj.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.*;


import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@CrossOrigin
@RestController
public class KorisnikController {
    @Autowired
    private final KorisnikService korisnikService;
    @Autowired
    private final PolicaService policaService;
    @Autowired
    private final AutorService autorService;
    @Autowired
    private final KnjigaService knjigaService;
    @Autowired
    public KorisnikController(KorisnikService korisnikService, PolicaService policaService,AutorService autorService,KnjigaService knjigaService) {
        this.korisnikService = korisnikService;
        this.policaService = policaService;
        this.autorService = autorService;
        this.knjigaService = knjigaService;
    }
    @PostMapping(path="/api/save-korisnik")
    public String saveKorisnik(Korisnik korisnik){
        this.korisnikService.save(korisnik);
        return "Korisnik uspješno sačuvan";
    }
    @PostMapping(path = "/api/login")
    public ResponseEntity<KorisnikDto> login(@RequestBody LoginDto loginDto, HttpSession session)
    {
        /*
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest != null)
        {
            if(korisnikTest.getEmail().equals(loginDto.getEmail())) {
                return ResponseEntity.badRequest().body(null);
            }
        }
        if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
        {
            return ResponseEntity.badRequest().body(null);
        }
        Korisnik korisnik = korisnikService.findKorisnikByEmail(loginDto.getEmail());
        if(korisnik == null)
        {
            return ResponseEntity.badRequest().body(null);
        }

        if(!korisnik.getLozinka().equals(loginDto.getPassword()))
        {
            return ResponseEntity.badRequest().body(null);
        }
        KorisnikDto korisnikDto = new KorisnikDto(korisnikTest.getIme(),korisnikTest.getPrezime(),korisnikTest.getKorisnicko_ime(),korisnikTest.getEmail(),korisnikTest.getLozinka(),korisnikTest.getDatum_rodjenja(),korisnikTest.getProfilna_slika(),korisnikTest.getUloga(),korisnikTest.getOpis());
        session.setAttribute("loggedUser",korisnik);
        return ResponseEntity.ok(korisnikDto );

         */

        if (loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        String mail = loginDto.getEmail();

        List<Autor> autori =  autorService.findAll();
        for(Autor dto : autori){
            if(dto.getEmail().equals(mail)) {
                if (dto.isAktivan()== false) {
                    return ResponseEntity.badRequest().body(null);
                }
            }
        }

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getEmail(), loginDto.getPassword(), session);
        if (loggedKorisnik == null) {
            return ResponseEntity.notFound().build();
        }

        KorisnikDto korisnikDto = new KorisnikDto();

        korisnikDto.setIme(loggedKorisnik.getIme());
        korisnikDto.setPrezime(loggedKorisnik.getPrezime());
        korisnikDto.setKorisnicko_ime(loggedKorisnik.getKorisnicko_ime());
        korisnikDto.setDatum_rodjenja(loggedKorisnik.getDatum_rodjenja());
        korisnikDto.setProfilna_slika(loggedKorisnik.getProfilna_slika());
        korisnikDto.setOpis(loggedKorisnik.getOpis());
        korisnikDto.setUloga(loggedKorisnik.getUloga());
        //korisnikDto.setPolice(loggedKorisnik.getPolice());

        session.setAttribute("loggedUser", loggedKorisnik);
        return ResponseEntity.ok(korisnikDto);
    }

    @PostMapping("api/logout")
    public ResponseEntity<String> Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("loggedUser");

        if (loggedKorisnik == null)
            return new ResponseEntity("Niste ni prijavljeni", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Uspješno izlogovan", HttpStatus.OK);
    }

    @PutMapping("api/admin/knjiga/{knjigaId}/update_knjiga")
    public ResponseEntity<?> updateKnjigaAdmin(@RequestBody UpdateKnjigaDto updateKnjigaDto, @PathVariable Long knjigaId, HttpSession session) throws ChangeSetPersister.NotFoundException  {
        knjigaService.updateKnjigaAdmin(knjigaId, updateKnjigaDto);
        return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);

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
        korisnikService.updateUser(korisnikTest.getId(),korisnikDto);
        return new ResponseEntity("Uspješno ažuriran.", HttpStatus.OK);
    }

    @GetMapping(path = "/api/my-police")
    public Set<Polica> mojePolice(HttpSession session)
    {
        Korisnik korisnik = (Korisnik)  session.getAttribute("loggedUser");
        if(korisnik == null)
        {
            return null;

        }
        Set<Polica> police = korisnik.getPolica();
        return police;
    }

}
