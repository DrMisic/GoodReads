package com.example.webProj.repository;

import com.example.webProj.entity.Knjiga;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Autor;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
    Boolean existsByEmail(String email);
    Boolean existsByLozinka(String lozinka);
    Boolean existsByKorisnickoIme(String korisnickoIme);

    Autor findAutorById(Long id);
    List<Autor> findAllByIme (String ime);
    List<Autor> findAllByAktivan (boolean isAktivan);

    List<Autor> findAllByPrezime (String prezime);
}
