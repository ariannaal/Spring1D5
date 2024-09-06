package com.example.Spring1D5.repositories;

import com.example.Spring1D5.entities.Edificio;
import com.example.Spring1D5.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

    List<Edificio> findById(int id);

    boolean existsById(int id);

    List<Edificio> findByCitta(String citta);

}
