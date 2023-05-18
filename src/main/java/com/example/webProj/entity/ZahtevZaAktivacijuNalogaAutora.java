package com.example.webProj.entity;

import jakarta.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;



@Entity
public class ZahtevZaAktivacijuNalogaAutora implements Serializable {
   public enum Status {
        NA_CEKANJU,
        ODOBREN,
        ODBIJEN
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;

    @Column
    private String telefon;

    @Column
    private String poruka;

    @Column
    private Date datum;

    @Column
    private Status status;

    @OneToOne
    private Autor autor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
