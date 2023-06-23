package com.example.webProj.service;


import com.example.webProj.dto.KnjigaDto;
import com.example.webProj.entity.*;
import com.example.webProj.repository.KnjigaRepository;
import com.example.webProj.repository.PolicaRepository;
import com.example.webProj.repository.ZanrRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    private PolicaRepository policaRepository;
    private PolicaService policaService;
    private ZanrRepository zanrRepository;
    private StavkaPoliceService stavkaPoliceService;

    private KnjigaService knjigaService;
    private KorisnikService korisnikService;

    public Knjiga findOne(Long id) {
        Optional<Knjiga> foundKnjiga = knjigaRepository.findById(id);
        if (foundKnjiga.isPresent()) {
            return foundKnjiga.get();
        }

        return null;
    }

    public Knjiga findOneByNaslov(String naslov) {
        return knjigaRepository.findOneByNaslov(naslov);
    }

    public List<Knjiga> findAllByISBN(double ISBN) {
        return knjigaRepository.findAllByISBN(ISBN);
    }

    public List<Knjiga> findAllByDatumObjavljivanja(Date datum) {
        return knjigaRepository.findAllByDatumObjavljivanja(datum);
    }

    public List<Knjiga> findAllByZanr(Zanr zanr) {
        return knjigaRepository.findAllByZanr(zanr);
    }

    public List<Knjiga> findAllByOcena(double ocena) {
        return knjigaRepository.findAllByOcena(ocena);
    }

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public Knjiga save(Knjiga knjiga) {
        return knjigaRepository.save(knjiga);
    }

    public Knjiga updateKnjiga(Long knjigaId, KnjigaDto updateKnjigaDto) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(knjigaId);
        knjiga.get().setNaslov(updateKnjigaDto.getNaslov());
        knjiga.get().setNaslovna_fotografija(updateKnjigaDto.getNaslovna_fotografija());

        double updatedISBN = updateKnjigaDto.getISBN();

        knjiga.get().setISBN(updatedISBN);

        knjiga.get().setDatum_objavljivanja(updateKnjigaDto.getDatum_objavljivanja());
        knjiga.get().setBroj_strana(updateKnjigaDto.getBroj_strana());
        knjiga.get().setOpis(updateKnjigaDto.getOpis());
        return save(knjiga.get());
    }

    public void deleteKnjiga(Long citalac_autor_Id, Long policaId, Long knjigaId) throws ChangeSetPersister.NotFoundException {
        Knjiga knjiga = knjigaRepository.findById(knjigaId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Korisnik korisnik = korisnikService.findOne(citalac_autor_Id);
        Polica polica = policaService.findOne(policaId);
        Set<Polica> korisnikovePolice = korisnik.getPolica();
        if (polica.isDaLiJePrimarno()) {
            if (polica.getNaziv().equals("Read")) {
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkaPolice().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkaPolice()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavkaPoliceService.deleteStavkaPolice(p.getId(), stavka.getId());
                            }
                        }
                    }
                }
            } else {
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkaPolice().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkaPolice()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavka.setKnjiga(null);
                            }
                        }
                    }
                }
            }
        } else {
            for (StavkaPolice stavka : polica.getStavkaPolice()) {
                if (stavka.getKnjiga().equals(knjiga)) {
                    stavkaPoliceService.deleteStavkaPolice(policaId, stavka.getId());
                }
            }
        }
    }

}
    /*
    public void deleteKnjiga(Long citalac_autor_Id, Long policaId, Long knjigaId) throws ChangeSetPersister.NotFoundException {
        Knjiga knjiga = knjigaRepository.findById(knjigaId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Korisnik korisnik = korisnikService.findOne(citalac_autor_Id);
        Polica polica = policaService.findOneById(policaId);
        Set<Polica> korisnikovePolice = korisnik.getPolice();
        if(polica.isPrimarna()){
            if(polica.getNaziv().equals("Read")){
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkePolica().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkePolica()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavkaPoliceService.deleteStavkaPolice(p.getId(), stavka.getId());
                            }
                        }
                    }
                }
            }
            else {
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkePolica().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkePolica()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavka.setKnjiga(null);
                            }
                        }
                    }
                }
            }
        }
        else {
            for (StavkaPolice stavka : polica.getStavkePolica()) {
                if (stavka.getKnjiga().equals(knjiga)) {
                    stavkaPoliceService.deleteStavkaPolice(policaId, stavka.getId());
                }
            }
        }
    }
    */



