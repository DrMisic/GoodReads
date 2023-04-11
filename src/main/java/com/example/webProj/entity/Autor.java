package com.example.webProj.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Autor extends Korisnik implements Serializable{
    @Column
    private boolean aktivan;
    @OneToMany(mappedBy = "autor",fetch = FetchType.LAZY, cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<Knjiga> spisakKnjiga = new HashSet<>();

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