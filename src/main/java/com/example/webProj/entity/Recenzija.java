package com.example.webProj.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private float ocena;

    @Column
    private String tekst;

    @Column
    private Date datumRecenzije;

    @OneToOne
    private Korisnik korisnik;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatum_recenzije() {
        return datumRecenzije;
    }

    public void setDatum_recenzije(Date datum_recenzije) {
        this.datumRecenzije = datum_recenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
