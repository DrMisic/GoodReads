package com.example.webProj.controller;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.service.KnjigaService;
import com.example.webProj.service.PolicaService;
import com.example.webProj.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@CrossOrigin
@RestController
public class StavkaPoliceController {
    public final StavkaPoliceService stavkaPoliceService;
    public final PolicaService policaService;
    public final KnjigaService knjigaService;
    @Autowired
    public StavkaPoliceController(StavkaPoliceService stavkaPoliceService, KnjigaService knjigaService,PolicaService policaService) {
        this.stavkaPoliceService = stavkaPoliceService;
        this.knjigaService = knjigaService;
        this.policaService = policaService;
    }

    @GetMapping(path = "/api/stavke_police")
    public List<StavkaPolice> getStavkePolice(){return stavkaPoliceService.findAll();}
    @GetMapping(path ="/api/stavka_police/{id}")
    public StavkaPolice getStavkaPolice(@PathVariable("id") Long id){return stavkaPoliceService.foundOne(id);}
    @GetMapping(path = "/api/stavka_police/{naslov_knjige}")
    public StavkaPolice getStavkaPoliceByKnjiga(@PathVariable("naslov_knjige")String naslovKnjige){

        return (StavkaPolice) stavkaPoliceService.findStavkaPoliceByKnjiga(knjigaService.findOneByNaslov(naslovKnjige));
    }
    @PostMapping(path =  "/api/save-stavka_police/{naslov}/polica/{policaid}")
    public ResponseEntity<String> saveStavkaPolice(@PathVariable("naslov") String naslov,@PathVariable(value="policaid")Long id, HttpSession session)
    {
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest == null)
        {
            return new ResponseEntity("Nisi ulogovan", HttpStatus.UNAUTHORIZED);
        }
        Knjiga knjiga = knjigaService.findOneByNaslov(naslov);
        Polica polica = policaService.findOne(id);
        if(knjiga == null || polica == null)
        {
            return new ResponseEntity("Neki od parametara nije dobro unesen", HttpStatus.BAD_REQUEST);
        }
        StavkaPolice stavkaPolice = new StavkaPolice();
        if(polica.isDaLiJePrimarno())
        {
            stavkaPolice.setKnjiga(knjiga);
        }else
        {
            for(StavkaPolice st:polica.getStavkaPolice())
            {

                if(st.getKnjiga().getId() == knjiga.getId())
                {
                    stavkaPolice.setKnjiga(knjiga);
                    this.stavkaPoliceService.save(stavkaPolice);
                    return new ResponseEntity("Uspješno sačuvana knjiga na polici", HttpStatus.OK);
                }
            }

            return new ResponseEntity("Knjiga se ne nalazi na primarnoj polici", HttpStatus.CONFLICT);

        }

        this.stavkaPoliceService.save(stavkaPolice);
        return new ResponseEntity("Uspješno sačuvana knjiga na polici", HttpStatus.OK);

    }

    @DeleteMapping(path =  "/api/delete-stavka_police/")
    public ResponseEntity<String> delStavkaPolice(@RequestParam(value="knjigaId") Long idk,@RequestParam(value="policaId")Long id, HttpSession session)
    {
        Korisnik korisnikTest =(Korisnik) session.getAttribute("loggedUser");
        if(korisnikTest == null)
        {
            return new ResponseEntity("Nisi ulogovan", HttpStatus.UNAUTHORIZED);

        }
        Knjiga knjiga = knjigaService.findOne(idk);
        Polica polica = policaService.findOne(id);
        for(StavkaPolice st:polica.getStavkaPolice())
        {
            if(st.getKnjiga().getId() == idk)
            {
                stavkaPoliceService.delStavkaPolice(idk);
                return new ResponseEntity("Uspješno obrisana knjiga na polici", HttpStatus.OK);
            }
        }



        return new ResponseEntity("Greška", HttpStatus.BAD_REQUEST);
    }

}
