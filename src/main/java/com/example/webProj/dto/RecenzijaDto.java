package com.example.webProj.dto;

import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Recenzija;


import java.util.Date;

public class RecenzijaDto {


    private float ocena;


    private String tekst;







    public RecenzijaDto(){}

    public RecenzijaDto( float ocena, String tekst,  Korisnik korisnik) {

        this.ocena = ocena;
        this.tekst = tekst;


    }

    public RecenzijaDto(Recenzija recenzija)
    {

        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();


    }


    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }






}
