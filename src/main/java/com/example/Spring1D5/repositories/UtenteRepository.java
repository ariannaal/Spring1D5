package com.example.Spring1D5.repositories;

import com.example.Spring1D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    List<Utente> findByNomeCompleto(String nomeCompleto);

    boolean existsByEmail(String email);

//    List<Utente> find();

}
