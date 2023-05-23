INSERT INTO polica(da_li_je_primarno,naziv) VALUES(1,'glavna polica');
INSERT INTO zanr(naslov) VALUES ('fikcija');
INSERT INTO knjiga(isbn,broj_strana,datum_objavljivanja,naslov,naslovna_fotografija,ocena,opis,zanr) VALUES ('1231','132','2022-01-01','12 pravila zivota','blank page','4.7','odlicna knjiga majke mi',1);

INSERT INTO stavka_police(knjiga) VALUES(1);
INSERT INTO korisnik(dtype,datum_rodjenja,email,ime,korisnicko_ime,lozinka,opis,prezime,profilna_slika,uloga,aktivan) VALUES (0,'2001-03-04','draganmisic@gmail.com','Dragan','DrMisic','qwarz123','NEMAM OPIS','Misic','nemam sliku',2,1);


INSERT INTO korisnik_polica(korisnik_id,polica) VALUES (1,1);
INSERT INTO korisnik_spisak_knjiga(autor_id,spisak_knjiga) VALUES(1,1);
INSERT INTO polica_stavka_police(polica_id,stavka_police) VALUES (1,1);



INSERT INTO zahtev_za_aktivaciju_naloga_autora(datum,email,poruka,status,telefon)  VALUES ('2022-01-03','draganmisic59@gmail.com','ooooo djes',0,'312421512');
INSERT INTO recenzija(datum_recenzije, ocena, tekst, korisnik) VALUES ('2022-01-02','4.3','dobro je',1);

INSERT INTO stavka_police_recenzija(stavka_police_id,recenzija) VALUES(1,1);