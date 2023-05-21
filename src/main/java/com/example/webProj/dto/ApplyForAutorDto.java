package com.example.webProj.dto;

public class ApplyForAutorDto {


    private String email;
    private String brojTelefona;
    private String poruka;

    public ApplyForAutorDto() {
    }

    public ApplyForAutorDto(String email, String brojTelefona, String poruka) {
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.poruka = poruka;
    }

    public ApplyForAutorDto(ZahtevZaAktivacijuNalogaAutoraDto zahtevZaAktivacijuNalogaAutoraDto)
    {
        this.email = zahtevZaAktivacijuNalogaAutoraDto.getEmail();
        this.brojTelefona = zahtevZaAktivacijuNalogaAutoraDto.getTelefon();
        this.poruka = zahtevZaAktivacijuNalogaAutoraDto.getPoruka();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
