package com.example.webProj.repository;

import com.example.webProj.entity.Autor;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;

import java.util.Date;
import java.util.List;

@Repository
public interface ZahtevZaAktivacijuNalogaAutoraRepository extends JpaRepository<ZahtevZaAktivacijuNalogaAutora,Long>{
    ZahtevZaAktivacijuNalogaAutora getZahtevZaAktivacijuNalogaAutoraByEmail(String email);
    List<ZahtevZaAktivacijuNalogaAutora> getZahtevZaAktivacijuNalogaAutoraByStatus(ZahtevZaAktivacijuNalogaAutora.Status status);
    ZahtevZaAktivacijuNalogaAutora getZahtevZaAktivacijuNalogaAutoraByAutor(Autor autor);
    List<ZahtevZaAktivacijuNalogaAutora> getZahtevZaAktivacijuNalogaAutoraByDatum(Date datum);

}
