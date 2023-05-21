package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Korisnik;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findKorisnikByKorisnickoIme(String korisnickoIme);
    Korisnik findKorisnikByEmail(String email);
    List<Korisnik> findAllByUloga(Korisnik.Uloge uloge);



}
