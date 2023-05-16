package com.example.webProj.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    private Set<Recenzija> recenzija = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Knjiga knjiga;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Set<Recenzija> getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Set<Recenzija> recenzija) {
        this.recenzija = recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }
}
