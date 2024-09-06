package com.example.Spring1D5.repositories;

import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    List<Postazione> findById(int id);

    boolean existsById(int id);

    List<Postazione> findByTipoPostazione(TipoPostazione tipoPostazione);

//    List<Prenotazione> findByUtenteIdAndData(Long utenteId, LocalDate data);
//
//    List<Prenotazione> findByPostazioneIdAndData(Long postazioneId, LocalDate data);


}
