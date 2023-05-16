package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;

@Repository
public interface ZahtevZaAktivacijuNalogaAutoraRepository extends JpaRepository<ZahtevZaAktivacijuNalogaAutora,Long>{
}
