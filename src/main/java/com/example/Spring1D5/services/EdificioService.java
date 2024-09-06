package com.example.Spring1D5.services;

import com.example.Spring1D5.entities.Edificio;
import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.EdificioRepository;
import com.example.Spring1D5.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio nuovoEdificio){

        if (edificioRepository.existsById(nuovoEdificio.getId())) {
            throw new ValidException("L'edificio con id' " + nuovoEdificio.getId() + " esiste gia'!");
        }

        edificioRepository.save(nuovoEdificio);

        System.out.println("Nuovo edificio " + nuovoEdificio.getNome() + " salvato con successo!");
    }

}
