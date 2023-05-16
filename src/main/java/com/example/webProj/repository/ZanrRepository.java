package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.Zanr;
@Repository
public interface ZanrRepository extends JpaRepository<Zanr,Long> {
}
