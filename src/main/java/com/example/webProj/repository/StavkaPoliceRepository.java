package com.example.webProj.repository;

import com.example.webProj.entity.Knjiga;
import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import  com.example.webProj.entity.StavkaPolice;
import java.util.List;

@Repository
public interface StavkaPoliceRepository  extends JpaRepository<StavkaPolice,Long>{

    StavkaPolice  getStavkaPoliceByKnjiga(Knjiga knjiga);
    void deleteById(Long id);
}
