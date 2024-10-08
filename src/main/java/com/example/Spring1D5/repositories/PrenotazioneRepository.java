package com.example.Spring1D5.repositories;

import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>  {

    List<Prenotazione> findById(int id);

    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate date);

    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate data);


}
