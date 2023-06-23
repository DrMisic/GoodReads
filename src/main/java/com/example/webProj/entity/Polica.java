package com.example.webProj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Polica implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;

    @Column
    private boolean daLiJePrimarno;
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<StavkaPolice> stavkaPolice = new HashSet<>();

    public Polica() {
    }

    public Polica(String naziv, boolean daLiJePrimarno) {
        this.naziv = naziv;
        this.daLiJePrimarno = daLiJePrimarno;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
