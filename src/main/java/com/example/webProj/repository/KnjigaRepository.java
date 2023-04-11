package com.example.webProj.repository;
import com.example.webProj.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnjigaRepository extends JpaRepository<Knjiga,Long> {
}