package com.example.webProj.dto;

import  com.example.webProj.entity.Zanr;
import  com.example.webProj.entity.Knjiga;

import java.util.Date;

public class KnjigaDto {


    private String naslov;

    private String naslovna_fotografija;

    private double ISBN;

    private Date datum_objavljivanja;

    private int broj_strana;

    private String opis;

   // private Zanr zanr;

    private float ocena;

    public KnjigaDto(){}
    public KnjigaDto( String naslov, String naslovna_fotografija, double ISBN, Date datum_objavljivanja, int broj_strana, String opis,  float ocena) {

        this.naslov = naslov;
        this.naslovna_fotografija = naslovna_fotografija;
        this.ISBN = ISBN;
        this.datum_objavljivanja = datum_objavljivanja;
        this.broj_strana = broj_strana;
        this.opis = opis;
        //this.zanr = zanr;
        this.ocena = ocena;
    }

    public KnjigaDto(Knjiga knjiga)
    {
        this.naslov = knjiga.getNaslov();
        this.naslovna_fotografija = knjiga.getNaslovna_fotografija();
        this.ISBN  = knjiga.getISBN();
        this.datum_objavljivanja = knjiga.getDatum_objavljivanja();
        this.broj_strana = knjiga.getBroj_strana();
        this.ocena = knjiga.getOcena();
        this.opis = knjiga.getOpis();
        //this.zanr = knjiga.getZanr();
    }



    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovna_fotografija() {
        return naslovna_fotografija;
    }

    public void setNaslovna_fotografija(String naslovna_fotografija) {
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
    /*
    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }
*/
    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
