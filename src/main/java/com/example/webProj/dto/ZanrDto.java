package com.example.webProj.dto;

import com.example.webProj.entity.Zanr;
public class ZanrDto {
    private Long id;
    private String naslov;

    public ZanrDto(){}

    public ZanrDto(Long id, String naslov) {
        this.id = id;
        this.naslov = naslov;
    }

    public  ZanrDto(Zanr zanr)
    {
        this.id = zanr.getId();
        this.naslov = zanr.getNaslov();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
}
