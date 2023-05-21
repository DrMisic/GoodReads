package com.example.webProj.controller;

import com.example.webProj.entity.Zanr;
import com.example.webProj.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZanrController {
    private final ZanrService zanrService;
    @Autowired
    public ZanrController(ZanrService zanrService) {
        this.zanrService = zanrService;
    }

    @GetMapping(path = "/api/zanrovi")
    public List<Zanr> getZanrovi(){return zanrService.findAll();}
    @GetMapping(path = "/api/zanr/{id}")
    public Zanr getZanr(@PathVariable("id")Long id){return zanrService.foundOne(id);}
    @GetMapping(path = "/api/zanr/{naslov}")
    public List<Zanr> getZanrByNaslov(@PathVariable("naslov") String naslov){return zanrService.findZanrByNaslov(naslov);}
    @PostMapping(path = "/api/save-zanr")
    public String saveZanr(Zanr zanr){
        this.zanrService.save(zanr);
        return "Uspješno sačuvan žanr";
    }
}
