package com.example.webProj.repository;

import com.example.webProj.entity.Korisnik;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Recenzija;

import java.util.Date;
import java.util.List;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija,Long> {

    List<Recenzija> getRecenzijaByKorisnik(Korisnik korisnik);
    List<Recenzija> getRecenzijaByDatumRecenzije(Date datumRecenzije);
}
