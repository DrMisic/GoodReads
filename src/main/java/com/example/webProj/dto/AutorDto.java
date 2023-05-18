package com.example.webProj.dto;

import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Knjiga;
import java.util.HashSet;
import java.util.Set;
public class AutorDto {
    private Long id;
    private boolean aktivan;
    private Set<Knjiga> spisakKnjiga = new HashSet<>();

    public AutorDto(){}
    public AutorDto(Long id, boolean aktivan, Set<Knjiga> spisakKnjiga) {
        this.id = id;
        this.aktivan = aktivan;
        this.spisakKnjiga = spisakKnjiga;
    }

    public AutorDto(Autor autor)
    {
        this.id = autor.getId();
        this.aktivan = autor.isAktivan();
        this.spisakKnjiga = autor.getSpisakKnjiga();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
