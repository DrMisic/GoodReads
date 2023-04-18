package com.example.webProj.entity;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String naslov;

    //popraviti tip za  naslovnu fotografiju
    @Column
    private Byte[] naslovna_fotografija;


    @Column
    private double ISBN;

    @Column
    private Date datum_objavljivanja;

    @Column
    private int broj_strana;

    @Column
    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Zanr zanr;

    @Column
    private float ocena;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Byte[] getNaslovna_fotografija() {
        return naslovna_fotografija;
    }

    public void setNaslovna_fotografija(Byte[] naslovna_fotografija) {
        this.naslovna_fotografija = naslovna_fotografija;
    }

    public double getISBN() {
        return ISBN;
    }

    public void setISBN(double ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatum_objavljivanja() {
        return datum_objavljivanja;
    }

    public void setDatum_objavljivanja(Date datum_objavljivanja) {
        this.datum_objavljivanja = datum_objavljivanja;
    }

    public int getBroj_strana() {
        return broj_strana;
    }

    public void setBroj_strana(int broj_strana) {
        this.broj_strana = broj_strana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
