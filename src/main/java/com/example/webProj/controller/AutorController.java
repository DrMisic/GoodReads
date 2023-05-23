package com.example.webProj.controller;

import com.example.webProj.dto.ApplyForAutorDto;
import com.example.webProj.entity.Autor;
import com.example.webProj.entity.Korisnik;
import com.example.webProj.entity.Polica;
import com.example.webProj.service.AutorService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.webProj.service.EmailSenderService;
import com.example.webProj.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

@RestController
public class AutorController {
    @Autowired
    private EmailSenderService senderService;
    private final AutorService autorService;
    private final KorisnikService korisnikService;

    @Autowired
    public AutorController(AutorService autorService, KorisnikService korisnikService,EmailSenderService senderService) {
        this.autorService = autorService;
        this.korisnikService = korisnikService;
        this.senderService = senderService;
    }

    @GetMapping(path = "/api/autori")
    public List<Autor> getAutors() {
        return autorService.findAll();
    }

    @GetMapping(path="/api/autor/{id}")
    public Autor getAutor(@PathVariable(name = "id") Long id) {
        Autor autor = autorService.findOne(id);
        return autor;
    }

    @GetMapping(path="/api/autor/{ime}")
    public List<Autor> getAllByIme(@PathVariable("ime") String ime)
    {
        List<Autor> autori = autorService.findAllByIme(ime);
        return autori;
    }

    @GetMapping(path="/api/autor/{prezime}")
    public List<Autor> getAllByPrezime(@PathVariable("prezime") String prezime)
    {
        List<Autor> autori = autorService.findAllByPrezime(prezime);
        return autori;
    }

    @GetMapping(path="/api/autor/aktivni")
    public List<Autor> getAllByIsAktivan(@PathVariable("isAktivan")boolean isAktivan)
    {
        List<Autor> autori = autorService.findAllByIsActive(isAktivan);
        return autori;
    }



    public static String generateSecurePassword() {

        // create character rule for lower case
        CharacterRule LCR = new CharacterRule(EnglishCharacterData.LowerCase);
        // set number of lower case characters
        LCR.setNumberOfCharacters(2);

        // create character rule for upper case
        CharacterRule UCR = new CharacterRule(EnglishCharacterData.UpperCase);
        // set number of upper case characters
        UCR.setNumberOfCharacters(2);

        // create character rule for digit
        CharacterRule DR = new CharacterRule(EnglishCharacterData.Digit);
        // set number of digits
        DR.setNumberOfCharacters(2);

        // create character rule for lower case
        CharacterRule SR = new CharacterRule(EnglishCharacterData.Special);
        // set number of special characters
        SR.setNumberOfCharacters(2);

        // create instance of the PasswordGenerator class
        PasswordGenerator passGen = new PasswordGenerator();

        // call generatePassword() method of PasswordGenerator class to get Passay generated password
        String password = passGen.generatePassword(8, SR, LCR, UCR, DR);

        // return Passay generated password to the main() method
        return password;
    }





    @PostMapping(path = "/api/accept-autor-request")
    public ResponseEntity<String> acceptAutor(@RequestBody ApplyForAutorDto applyForAutorDto, HttpSession session)
    {
        Korisnik loggedUser = (Korisnik) session.getAttribute("loggedUser");
        if(loggedUser == null)
        {
            return new ResponseEntity<>("Nema sesije", HttpStatus.FORBIDDEN);
        }
        loggedUser = korisnikService.findOne(loggedUser.getId());

        if(!(loggedUser.getUloga()== Korisnik.Uloge.ADMINISTRATOR))
        {
            return new ResponseEntity<>("Niste administrator", HttpStatus.FORBIDDEN);
        }

        Autor autor = new Autor();
        autor.setEmail(applyForAutorDto.getEmail());

        String generatedPassword = generateSecurePassword();
        autor.setLozinka(generatedPassword);
        Polica primarnaPolicaWantToRead = new Polica("Want to read",true);
        Polica primarnaPolicaCurrentlyReading = new Polica("Currently reading",true);
        Polica primarnaPolicaRead = new Polica("Read",true);
        Set<Polica> police = new HashSet<>();
        police.add(primarnaPolicaWantToRead);
        police.add(primarnaPolicaCurrentlyReading);
        police.add(primarnaPolicaRead);
        autor.setPolica(police);
        autor.setAktivan(true);
        String subject = new String("Aktivacija naloga [GoodReads]");
        String text =new String ("Poštovani "+autor.getEmail()+" vaša lozinka je: "+ autor.getLozinka()+"\n Molimo vas da promjenite lozinku.");
        senderService.sendEmail(applyForAutorDto.getEmail(), subject,text);




        autorService.save(autor);
        return new ResponseEntity<>("Dodat je autor",HttpStatus.OK);
    }

    @PostMapping(path = "/api/reject-autor-request")
    public ResponseEntity<String> rejectAutor(@RequestBody ApplyForAutorDto applyForAutorDto,HttpSession session)
    {
        Korisnik loggedUser = (Korisnik) session.getAttribute("loggedUser");
        if(loggedUser == null)
        {
            return new ResponseEntity<>("Nema sesije", HttpStatus.FORBIDDEN);
        }
        loggedUser = korisnikService.findOne(loggedUser.getId());

        if(!(loggedUser.getUloga()== Korisnik.Uloge.ADMINISTRATOR))
        {
            return new ResponseEntity<>("Niste administrator", HttpStatus.FORBIDDEN);
        }
        String subject = new String("Odbijen zahtjev za autora [GoodReads]");
        String text = new String("Zahtjev je odbijen!");
        senderService.sendEmail(applyForAutorDto.getEmail(), subject,text);
        return new ResponseEntity<>("Odbijen je autor",HttpStatus.OK);
    }

}
