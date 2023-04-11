package com.example.webProj.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Polica implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String naziv;

    @Column
    private boolean daLiJePrimarno;

    @OneToMany(mappedBy = "polica",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private StavkaPolice stavkaPolice;

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

    public StavkaPolice getStavkaPolice() {
        return stavkaPolice;
    }

    public void setStavkaPolice(StavkaPolice stavkaPolice) {
        this.stavkaPolice = stavkaPolice;
    }
}
