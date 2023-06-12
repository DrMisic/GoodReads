package com.example.webProj.dto;

import com.example.webProj.entity.Polica;
import com.example.webProj.entity.StavkaPolice;

import java.util.HashSet;
import java.util.Set;

public class PolicaDto {

    private String naziv;




    public PolicaDto(){}

    public PolicaDto( String naziv,  Set<StavkaPolice> stavkaPolice) {

        this.naziv = naziv;


    }

    public PolicaDto(Polica polica)
    {

        this.naziv = polica.getNaziv();


    }





    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }




}
