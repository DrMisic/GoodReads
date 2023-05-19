package com.example.webProj.controller;

import com.example.webProj.entity.Autor;
import com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;
import com.example.webProj.service.ZahtevZaAktivacijuNalogaAutoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

}
