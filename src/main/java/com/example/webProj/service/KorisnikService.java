package com.example.webProj.service;

import com.example.webProj.dto.KorisnikDto;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.repository.KorisnikRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if(foundKorisnik.isPresent())
        {
            return foundKorisnik.get();
        }

        return null;
    }

    public Korisnik findKorisnikByKorisnickoIme(String korisnickoIme){return korisnikRepository.findKorisnikByKorisnickoIme(korisnickoIme);}
    public Korisnik findKorisnikByEmail(String email){return korisnikRepository.findKorisnikByEmail(email);}
    public List<Korisnik> findAllByUloga(Korisnik.Uloge uloga){return korisnikRepository.findAllByUloga(uloga);}
    public List<Korisnik> findAll(){return korisnikRepository.findAll();}
    public Korisnik save(Korisnik korisnik){return korisnikRepository.save(korisnik);}

    public Korisnik login(String username, String password, HttpSession session) {
        Korisnik korisnik = korisnikRepository.findKorisnikByEmail(username);
        if (korisnik == null || !korisnik.getLozinka().equals(password)) {
            return null;
        }

        session.setAttribute("employee", korisnik);
        return korisnik;
    }
    public Korisnik updateUser(Long id, KorisnikDto updateDto){
        Korisnik korisnik = findOne(id);

        if(korisnik == null)
        {
            return null;
        }

        korisnik.setIme(updateDto.getIme());
        korisnik.setPrezime(updateDto.getPrezime());
        korisnik.setProfilna_slika(updateDto.getProfilna_slika());
        korisnik.setDatum_rodjenja(updateDto.getDatum_rodjenja());
        korisnik.setOpis(updateDto.getOpis());
        korisnik.setUloga(Korisnik.Uloge.CITALAC);





        return save(korisnik);
    }

}
