package com.example.Spring1D5.services;

import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.enums.TipoPostazione;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.PostazioneRepository;
import com.example.Spring1D5.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione nuovaPostazione){

        postazioneRepository.save(nuovaPostazione);

        if (nuovaPostazione.getCodiceUnivoco() == null) {
            throw new IllegalArgumentException("Il codice Univoco non puo' essere null");
        }

        System.out.println("Nuova postazione con Codice Univoco " + nuovaPostazione.getCodiceUnivoco() + " salvata con successo!");
    }

    public List<Postazione> findByTipoPostazione(TipoPostazione tipoPostazione) {
        return postazioneRepository.findByTipoPostazione(tipoPostazione);
    }


}
