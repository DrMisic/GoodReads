package com.example.webProj.repository;
import com.example.webProj.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
}
