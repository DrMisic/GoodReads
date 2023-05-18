package com.example.webProj.dto;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Recenzija;
import com.example.webProj.entity.StavkaPolice;


import java.util.HashSet;
import java.util.Set;

public class StavkaPoliceDto {
    private Long id;
    private Set<Recenzija> recenzija = new HashSet<>();
    private Knjiga knjiga;

    public StavkaPoliceDto(){}

    public StavkaPoliceDto(Long id, Set<Recenzija> recenzija, Knjiga knjiga) {
        this.id = id;
        this.recenzija = recenzija;
        this.knjiga = knjiga;
    }

    public StavkaPoliceDto(StavkaPolice stavkaPolice)
    {
        this.id = stavkaPolice.getId();
        this.recenzija = stavkaPolice.getRecenzija();
        this.knjiga = stavkaPolice.getKnjiga();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Recenzija> getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Set<Recenzija> recenzija) {
        this.recenzija = recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
}
