package com.example.Spring1D5.services;

import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente newUtente){

        // controllo se esiste già un utente con questa email
        if(UtenteRepository.existsByEmail(newUtente.getEmail())) throw new ValidException("L'email " + newUtente.getEmail() + " è già in utilizzo!");

        if(newUtente.getNomeCompleto().length() < 2) throw new ValidException("Nome troppo corto!");

        utenteRepository.save(newUtente);

        System.out.println("Nuovo utente " + newUtente.getEmail() + " salvato con successo!");
    }

    public List<Utente> findByNomeCompleto(String nomeCompleto) {
        return utenteRepository.findByNomeCompleto(nomeCompleto);
    }

}
