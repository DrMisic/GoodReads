package com.example.webProj.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Autor extends Korisnik implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean aktivan;

    @OneToMany()
    private Set<Knjiga> spisakKnjiga = new HashSet<>();

    public Autor() {
    }

    public Autor(boolean aktivan, Set<Knjiga> spisakKnjiga) {
        this.aktivan = aktivan;
        this.spisakKnjiga = spisakKnjiga;
    }



    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Knjiga> getSpisakKnjiga() {
        return spisakKnjiga;
    }

    public void setSpisakKnjiga(Set<Knjiga> spisakKnjiga) {
        this.spisakKnjiga = spisakKnjiga;
    }
}
