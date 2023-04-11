package com.example.webProj.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recenzija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private float ocena;

    @Column
    private String tekst;

    @Column
    private Date datum_recenzije;

    @OneToOne
    private Korisnik korisnik;
}
