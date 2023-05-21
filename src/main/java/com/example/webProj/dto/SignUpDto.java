package com.example.webProj.dto;

public class SignUpDto {
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private String lozinkaDrugiPut;

    public SignUpDto() {
    }

    public SignUpDto(String ime, String prezime, String korisnickoIme, String email, String lozinka, String lozinkaDrugiPut) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.lozinka = lozinka;
        this.lozinkaDrugiPut = lozinkaDrugiPut;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
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

    public String getLozinkaDrugiPut() {
        return lozinkaDrugiPut;
    }

    public void setLozinkaDrugiPut(String lozinkaDrugiPut) {
        this.lozinkaDrugiPut = lozinkaDrugiPut;
    }
}
