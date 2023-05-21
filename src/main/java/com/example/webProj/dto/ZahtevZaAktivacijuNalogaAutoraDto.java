package com.example.webProj.dto;

import com.example.webProj.entity.Autor;
import com.example.webProj.entity.ZahtevZaAktivacijuNalogaAutora;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class ZahtevZaAktivacijuNalogaAutoraDto {
    private Long id;
    private String email;

    private String telefon;

    private String poruka;

    private Date datum;

    private ZahtevZaAktivacijuNalogaAutora.Status status;

    private Autor autor;

    public ZahtevZaAktivacijuNalogaAutoraDto(){}

    public ZahtevZaAktivacijuNalogaAutoraDto(Long id, String email, String telefon, String poruka, Date datum, ZahtevZaAktivacijuNalogaAutora.Status status, Autor autor) {
        this.id = id;
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.datum = datum;
        this.status = status;
        this.autor = autor;
    }

    public ZahtevZaAktivacijuNalogaAutoraDto(ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora)
    {
        this.id = zahtevZaAktivacijuNalogaAutora.getId();
        this.email = zahtevZaAktivacijuNalogaAutora.getEmail();
        this.telefon = zahtevZaAktivacijuNalogaAutora.getTelefon();
        this.poruka = zahtevZaAktivacijuNalogaAutora.getPoruka();
        this.datum = zahtevZaAktivacijuNalogaAutora.getDatum();
        this.status = zahtevZaAktivacijuNalogaAutora.getStatus();
        this.autor = zahtevZaAktivacijuNalogaAutora.getAutor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public ZahtevZaAktivacijuNalogaAutora.Status getStatus() {
        return status;
    }

    public void setStatus(ZahtevZaAktivacijuNalogaAutora.Status status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
