package com.example.webProj.dto;

import com.example.webProj.entity.Polica;
import com.example.webProj.entity.Korisnik;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class KorisnikDto {

    private Long id;

    private String ime;

    private String prezime;

    private String korisnicko_ime;

    private String email;

    private String lozinka;

    private Date datum_rodjenja;
    // moram naći pravi tip podatka za profilnu sliku

    private String profilna_slika;


    private String opis;


    private Korisnik.Uloge uloga;


    //private Set<Polica> polica = new HashSet<>();

    public KorisnikDto(){}

    public KorisnikDto( String ime, String prezime, String korisnicko_ime, String email, String lozinka, Date datum_rodjenja, String profilna_slika,Korisnik.Uloge uloga, String opis) {
        //this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnicko_ime = korisnicko_ime;
        this.email = email;
        this.lozinka = lozinka;
        this.datum_rodjenja = datum_rodjenja;
        this.profilna_slika = profilna_slika;
        this.opis = opis;
        this.uloga = uloga;
        //this.polica = polica;
    }

    public KorisnikDto(Korisnik korisnik)
    {
        //this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnicko_ime = korisnik.getKorisnicko_ime();
        this.email = korisnik.getEmail();
        this.lozinka = korisnik.getLozinka();
        this.datum_rodjenja = korisnik.getDatum_rodjenja();
        this.profilna_slika = korisnik.getProfilna_slika();
        this.opis = korisnik.getOpis();
        this.uloga = korisnik.getUloga();
        //this.polica = korisnik.getPolica();
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Korisnik.Uloge getUloga() {
        return uloga;
    }

    public void setUloga(Korisnik.Uloge uloga) {
        this.uloga = uloga;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getProfilna_slika() {
        return profilna_slika;
    }

    public void setProfilna_slika(String profilna_slika) {
        this.profilna_slika = profilna_slika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    /*
    public Set<Polica> getPolica() {
        return polica;
    }

    public void setPolica(Set<Polica> polica) {
        this.polica = polica;
    }

     */
}
