package com.example.webProj.repository;

import com.example.webProj.entity.Zanr;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Knjiga;

import java.util.Date;
import java.util.List;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga,Long> {
    Knjiga findOneByNaslov (String naslov);

    List<Knjiga> findAllByISBN (double ISBN);

    List<Knjiga> findAllByDatumObjavljivanja (Date datum);
    List<Knjiga> findAllByZanr (Zanr zanr);

    List<Knjiga> findAllByOcena (double ocena);

    void deleteById(Long id);



}
