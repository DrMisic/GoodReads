package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Knjiga;
@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga,Long> {
}
