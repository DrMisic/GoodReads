package com.example.webProj.dto;

import com.example.webProj.entity.Polica;
import com.example.webProj.entity.StavkaPolice;

import java.util.HashSet;
import java.util.Set;

public class PolicaDto {
    private Long id;
    private String naziv;
    private boolean daLiJePrimarno;

    private Set<StavkaPolice> stavkaPolice = new HashSet<>();

    public PolicaDto(){}

    public PolicaDto(Long id, String naziv, boolean daLiJePrimarno, Set<StavkaPolice> stavkaPolice) {
        this.id = id;
        this.naziv = naziv;
        this.daLiJePrimarno = daLiJePrimarno;
        this.stavkaPolice = stavkaPolice;
    }

    public PolicaDto(Polica polica)
    {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.daLiJePrimarno = polica.isDaLiJePrimarno();
        this.stavkaPolice = polica.getStavkaPolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isDaLiJePrimarno() {
        return daLiJePrimarno;
    }

    public void setDaLiJePrimarno(boolean daLiJePrimarno) {
        this.daLiJePrimarno = daLiJePrimarno;
    }

    public Set<StavkaPolice> getStavkaPolice() {
        return stavkaPolice;
    }

    public void setStavkaPolice(Set<StavkaPolice> stavkaPolice) {
        this.stavkaPolice = stavkaPolice;
    }
}
