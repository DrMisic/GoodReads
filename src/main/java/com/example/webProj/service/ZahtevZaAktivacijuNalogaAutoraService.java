package com.example.webProj.service;

import com.example.webProj.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;
import com.example.webProj.repository.ZahtevZaAktivacijuNalogaAutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ZahtevZaAktivacijuNalogaAutoraService {
    @Autowired
    public ZahtevZaAktivacijuNalogaAutoraRepository zahtevZaAktivacijuNalogaAutoraRepository;
    public ZahtevZaAktivacijuNalogaAutora saveDto(ZahtevZaAktivacijuNalogaAutoraDto zanaDto) {
        ZahtevZaAktivacijuNalogaAutora zana =  new ZahtevZaAktivacijuNalogaAutora();
        zana.setDatum(zanaDto.getDatum());
        zana.setStatus(zanaDto.getStatus());
        zana.setPoruka(zanaDto.getPoruka());
        zana.setTelefon(zanaDto.getTelefon());
        zana.setEmail(zanaDto.getEmail());
        zana.setAutor(zanaDto.getAutor());
        return zahtevZaAktivacijuNalogaAutoraRepository.save(zana);
    }
    public ZahtevZaAktivacijuNalogaAutora foundOne(Long id)
    {
        Optional<ZahtevZaAktivacijuNalogaAutora> foundZahtevZaAktivacijuNalogaAutora = zahtevZaAktivacijuNalogaAutoraRepository.findById(id);
        if(foundZahtevZaAktivacijuNalogaAutora.isPresent())
        {
            return foundZahtevZaAktivacijuNalogaAutora.get();
        }

        return null;
    }
    public void deleteId(Long id)
    {
        zahtevZaAktivacijuNalogaAutoraRepository.deleteById(id);
    }

    public ZahtevZaAktivacijuNalogaAutora findZahtevZaAktivacijuNalogaAutoraByEmail(String email){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByEmail(email);}
    public ZahtevZaAktivacijuNalogaAutora findZahtevZaAktivacijuNalogaAutoraByAutor(Autor autor){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByAutor(autor);}
    public List<ZahtevZaAktivacijuNalogaAutora> findZahtevZaAktivacijuNalogaAutoraByStatus(ZahtevZaAktivacijuNalogaAutora.Status status){return  zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByStatus(status);}
    public List<ZahtevZaAktivacijuNalogaAutora> findZahtevZaAktivacijuNalogaAutoraByDatum(Date datum){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByDatum(datum);}
    public List<ZahtevZaAktivacijuNalogaAutora> findAll(){return zahtevZaAktivacijuNalogaAutoraRepository.findAll();}
    public ZahtevZaAktivacijuNalogaAutora save(ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora){return  zahtevZaAktivacijuNalogaAutoraRepository.save(zahtevZaAktivacijuNalogaAutora);}
}
