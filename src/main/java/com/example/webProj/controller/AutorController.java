package com.example.webProj.controller;

import com.example.webProj.entity.Autor;
import com.example.webProj.service.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
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

    @PostMapping(path="/api/save-autor")
    public String saveAutor(@RequestBody Autor autor)
    {
        this.autorService.save(autor);
        return "Uspješno sačuvan autor";
    }
}
