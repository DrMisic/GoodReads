package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Polica;


@Repository
public interface PolicaRepository extends JpaRepository<Polica,Long> {
}
