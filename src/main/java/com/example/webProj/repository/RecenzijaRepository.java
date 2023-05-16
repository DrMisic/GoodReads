package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Recenzija;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija,Long> {
}
