package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
}
