package com.example.webProj.controller;

import com.example.webProj.dto.ApplyForAutorDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;
import com.example.webProj.service.ZahtevZaAktivacijuNalogaAutoraService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
public class ZahtevZaAktivacijuNalogaAutoraController {
    public final ZahtevZaAktivacijuNalogaAutoraService zahtevZaAktivacijuNalogaAutoraService;
    @Autowired
    public ZahtevZaAktivacijuNalogaAutoraController(ZahtevZaAktivacijuNalogaAutoraService zahtevZaAktivacijuNalogaAutoraService) {
        this.zahtevZaAktivacijuNalogaAutoraService = zahtevZaAktivacijuNalogaAutoraService;
    }

    @GetMapping(path = "/api/zahtevi_za_aktivaciju_naloga_autora")
    public List<ZahtevZaAktivacijuNalogaAutora> getZahteviZaAktivacijuAutora(){return zahtevZaAktivacijuNalogaAutoraService.findAll();}
    @GetMapping(path = "/api/zahtev_za_aktivaciju_naloga_autora/{id}")
    public ZahtevZaAktivacijuNalogaAutora getZahtevZaAktivacijuNalogaAutoraById(@PathVariable("id")Long id){return zahtevZaAktivacijuNalogaAutoraService.foundOne(id);}
    @GetMapping(path = "/api/zahtev_za_aktivaciju_naloga_autora/{email}")
    public ZahtevZaAktivacijuNalogaAutora getZahtevZaAktivacijuNalogaAutoraByEmail(@PathVariable("email") String email){return  zahtevZaAktivacijuNalogaAutoraService.findZahtevZaAktivacijuNalogaAutoraByEmail(email);}
    @GetMapping(path = "/api/zahtev_za_aktivaciju_naloga_autora/{autor}")
    public ZahtevZaAktivacijuNalogaAutora getZahtevZaAktivacijuNalogaAutoraByAutor(@PathVariable("autor")Autor autor){return  zahtevZaAktivacijuNalogaAutoraService.findZahtevZaAktivacijuNalogaAutoraByAutor(autor);}
    @GetMapping(path = "/api/zahtev_za_aktivaciju_naloga_autora/{status}")
    public List<ZahtevZaAktivacijuNalogaAutora> getZahtevZaAktivacijuNalogaAutoraByStatus(@PathVariable("status")ZahtevZaAktivacijuNalogaAutora.Status status){return  zahtevZaAktivacijuNalogaAutoraService.findZahtevZaAktivacijuNalogaAutoraByStatus(status);}
    @GetMapping(path = "/api/zahtev_za_aktivaciju_naloga_autora/{datum}")
    public List<ZahtevZaAktivacijuNalogaAutora> getZahtevZaAktivacijuNalogaAutoraByEmail(@PathVariable("datum")Date datum) {return  zahtevZaAktivacijuNalogaAutoraService.findZahtevZaAktivacijuNalogaAutoraByDatum(datum);}
    @PostMapping(path = "/api/save-zahtev_za_aktivaciju_naloga_autora")
    public String saveZahtevZaAktivacijuNalogaAutora(ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora){
        this.zahtevZaAktivacijuNalogaAutoraService.save(zahtevZaAktivacijuNalogaAutora);
        return "Uspješno sačuvan zahtjev za aktivaciju naloga autora";
    }

    @PostMapping(path = "/api/podnesi_zahtev_za_aktivaciju_naloga_autora")
    public ResponseEntity<String> applyForAutor(@RequestBody  ApplyForAutorDto applyForAutorDto, HttpSession session)
    {
        System.out.println("stigao sam1");
        if(applyForAutorDto.getEmail().isEmpty() || applyForAutorDto.getBrojTelefona().isEmpty())
        {
            System.out.println("stigao sam2");
            return new ResponseEntity("Unesite sve podatke", HttpStatus.BAD_REQUEST);
        }
        ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora = new ZahtevZaAktivacijuNalogaAutora();
        zahtevZaAktivacijuNalogaAutora.setEmail(applyForAutorDto.getEmail());
        zahtevZaAktivacijuNalogaAutora.setTelefon(applyForAutorDto.getBrojTelefona());
        zahtevZaAktivacijuNalogaAutora.setPoruka(applyForAutorDto.getPoruka());
        zahtevZaAktivacijuNalogaAutora.setStatus(ZahtevZaAktivacijuNalogaAutora.Status.NA_CEKANJU);
        java.util.Date currentDate = new java.util.Date();
        zahtevZaAktivacijuNalogaAutora.setDatum(currentDate);
        System.out.println("stigao sam3");
        this.zahtevZaAktivacijuNalogaAutoraService.save(zahtevZaAktivacijuNalogaAutora);

        return ResponseEntity.ok("Uspješno poslat zahtjev");
    }

}
