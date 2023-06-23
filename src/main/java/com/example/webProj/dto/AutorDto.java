package com.example.webProj.dto;

import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Korisnik;

import java.util.HashSet;
import java.util.Set;
public class AutorDto extends KorisnikDto {

    private boolean aktivan;
    private Set<Knjiga> spisakKnjiga = new HashSet<>();

    public AutorDto(){}
    public AutorDto(boolean aktivan ) {
        this.aktivan = aktivan;

    }

    public AutorDto(Autor autor)
    {
        this.aktivan = autor.isAktivan();

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
