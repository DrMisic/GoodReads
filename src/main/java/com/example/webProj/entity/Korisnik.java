package com.example.webProj.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

enum Uloge {
    KORISNIK,
    AUTOR,
    ADMINISTRATOR
}
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(unique = true)
    private String korisnicko_ime;

    @Column(unique = true)
    private String email;
    @Column
    private String lozinka;

    @Column
    private Date datum_rodjenja;
    // moram naći pravi tip podatka za profilnu sliku
    @Column
    private String profilna_slika;

    @Column
    private String opis;

    @Column
    private Uloge uloga;

    @OneToMany
    private Set<Polica> polica = new HashSet<>();

    public Set<Polica> getPolica() {
        return polica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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

    public Uloge getUloga() {
        return uloga;
    }

    public void setUloga(Uloge uloga) {
        this.uloga = uloga;
    }

    public void setPolica(Set<Polica> polica) {
        this.polica = polica;
    }

}
