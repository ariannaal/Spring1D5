package com.example.Spring1D5.services;

import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.PrenotazioneRepository;
import com.example.Spring1D5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione nuovaPrenotazione){

        prenotazioneRepository.save(nuovaPrenotazione);

        System.out.println("Nuova prenotazione " + nuovaPrenotazione.getId() + " salvato con successo!");
    }

    }


