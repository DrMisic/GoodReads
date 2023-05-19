package com.example.webProj.service;

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

    public ZahtevZaAktivacijuNalogaAutora foundOne(Long id)
    {
        Optional<ZahtevZaAktivacijuNalogaAutora> foundZahtevZaAktivacijuNalogaAutora = zahtevZaAktivacijuNalogaAutoraRepository.findById(id);
        if(foundZahtevZaAktivacijuNalogaAutora.isPresent())
        {
            return foundZahtevZaAktivacijuNalogaAutora.get();
        }

        return null;
    }

    public ZahtevZaAktivacijuNalogaAutora findZahtevZaAktivacijuNalogaAutoraByEmail(String email){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByEmail(email);}
    public ZahtevZaAktivacijuNalogaAutora findZahtevZaAktivacijuNalogaAutoraByAutor(Autor autor){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByAutor(autor);}
    public List<ZahtevZaAktivacijuNalogaAutora> findZahtevZaAktivacijuNalogaAutoraByStatus(ZahtevZaAktivacijuNalogaAutora.Status status){return  zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByStatus(status);}
    public List<ZahtevZaAktivacijuNalogaAutora> findZahtevZaAktivacijuNalogaAutoraByDatum(Date datum){return zahtevZaAktivacijuNalogaAutoraRepository.getZahtevZaAktivacijuNalogaAutoraByDatum(datum);}
    public List<ZahtevZaAktivacijuNalogaAutora> findAll(){return zahtevZaAktivacijuNalogaAutoraRepository.findAll();}
    public ZahtevZaAktivacijuNalogaAutora save(ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora){return  zahtevZaAktivacijuNalogaAutoraRepository.save(zahtevZaAktivacijuNalogaAutora);}
}
