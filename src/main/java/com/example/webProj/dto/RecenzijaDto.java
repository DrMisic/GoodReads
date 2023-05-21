package com.example.webProj.dto;

import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Recenzija;


import java.util.Date;

public class RecenzijaDto {
    private Long id;

    private float ocena;


    private String tekst;


    private Date datum_recenzije;


    private Korisnik korisnik;

    public RecenzijaDto(){}

    public RecenzijaDto(Long id, float ocena, String tekst, Date datum_recenzije, Korisnik korisnik) {
        this.id = id;
        this.ocena = ocena;
        this.tekst = tekst;
        this.datum_recenzije = datum_recenzije;
        this.korisnik = korisnik;
    }

    public RecenzijaDto(Recenzija recenzija)
    {
        this.id = recenzija.getId();
        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();
        this.datum_recenzije = recenzija.getDatum_recenzije();
        this.korisnik = recenzija.getKorisnik();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return datum_recenzije;
    }

    public void setDatum_recenzije(Date datum_recenzije) {
        this.datum_recenzije = datum_recenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
