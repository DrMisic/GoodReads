package com.example.webProj.service;

import com.example.webProj.entity.Knjiga;
import com.example.webProj.entity.Polica;
import com.example.webProj.entity.StavkaPolice;
import com.example.webProj.repository.StavkaPoliceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Transactional
@Service
public class StavkaPoliceService {
    @Autowired
    public StavkaPoliceRepository stavkaPoliceRepository;
    public PolicaService policaService;

    public StavkaPolice foundOne(Long id)
    {
        Optional<StavkaPolice> foundStavkaPolice = stavkaPoliceRepository.findById(id);
        if(foundStavkaPolice.isPresent())
        {
            return foundStavkaPolice.get();
        }

        return null;
    }

    public List<StavkaPolice> findAll(){return stavkaPoliceRepository.findAll();}
    public StavkaPolice findStavkaPoliceByKnjiga(Knjiga knjiga){return stavkaPoliceRepository.getStavkaPoliceByKnjiga(knjiga);}
    public StavkaPolice  save(StavkaPolice stavkaPolice){return stavkaPoliceRepository.save(stavkaPolice);}
    public void delStavkaPolice(Long id){stavkaPoliceRepository.deleteById(id);}
    public void deleteStavkaPolice(Long policaId,Long stavkaId) throws ChangeSetPersister.NotFoundException {
        StavkaPolice stavkaPolice = stavkaPoliceRepository.findById(stavkaId)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        Polica polica = policaService.findOne(policaId);

        Set<StavkaPolice> stavkePolice = polica.getStavkaPolice();
        if(stavkePolice == null)
        {
            return ;
        }
        stavkePolice.remove(stavkaPolice);
        stavkaPoliceRepository.delete(stavkaPolice);
        polica.setStavkaPolice(stavkePolice);
        policaService.save(polica);

    }
}
