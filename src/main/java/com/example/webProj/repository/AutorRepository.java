package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
