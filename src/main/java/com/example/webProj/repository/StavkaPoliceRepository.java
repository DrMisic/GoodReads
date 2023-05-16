package com.example.webProj.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.StavkaPolice;

@Repository
public interface StavkaPoliceRepository  extends JpaRepository<StavkaPolice,Long>{
}
