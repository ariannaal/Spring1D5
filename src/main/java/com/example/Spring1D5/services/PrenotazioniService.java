package com.example.Spring1D5.services;

import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.PrenotazioneRepository;
import com.example.Spring1D5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class PrenotazioniService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione nuovaPrenotazione){

        prenotazioneRepository.save(nuovaPrenotazione);

        System.out.println("Nuova prenotazione con id " + nuovaPrenotazione.getId() + " salvata con successo!");
    }

    // prenotazione di una postazione
    public void prenota(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        // verifico se la prenotazione e' disponibile
        List<Prenotazione> prenotazioniEsistenti = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        if (!prenotazioniEsistenti.isEmpty()) {
            System.out.println("La postazione non è disponibile per la data selezionata.");
            return;
        }

        Random random = new Random();
        int giornoRandom = random.nextInt(31);
        int meseRandom = random.nextInt(12);
        LocalDate dataRandom = LocalDate.of(2024, meseRandom, giornoRandom);

        // verifica se l'utente ha già una prenotazione per la data
        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataRandom);
        if (!prenotazioniUtente.isEmpty()) {
            System.out.println("L'utente ha già una prenotazione per la data selezionata.");
        }

        // salva la prenotazione
        Prenotazione prenotazione = new Prenotazione(dataPrenotazione, postazione, utente);
        prenotazioneRepository.save(prenotazione);
    }

    }


