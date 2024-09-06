package com.example.Spring1D5.entities;
import com.example.Spring1D5.enums.TipoPostazione;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    private Faker faker = new Faker();

    // bean per gli edifici
    @Bean
    public Edificio edificio1() {
        return new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
    }

    @Bean
    public Edificio edificio2() {
        return new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
    }

    @Bean
    public Edificio edificio3() {
        return new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
    }

    // bean per le postazioni
    @Bean
    public Postazione postazione1() {
        return new Postazione("Postazione privata con vista", TipoPostazione.PRIVATO, 1, edificio1());
    }

    @Bean
    public Postazione postazione2() {
        return new Postazione("Postazione open space", TipoPostazione.OPENSPACE, 5, edificio2());
    }

    @Bean
    public Postazione postazione3() {
        return new Postazione("Sala riunioni grande", TipoPostazione.SALA_RIUNIONI, 10, edificio3());
    }

    // bean per gli utenti
    @Bean
    public Utente utente1() {
        return new Utente(faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    public Utente utente2() {
        return new Utente(faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    public Utente utente3() {
        return new Utente(faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    public Utente utente4() {
        return new Utente(faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    public Utente utente5() {
        return new Utente(faker.name().lastName(), faker.internet().emailAddress());
    }

    @Bean
    public Prenotazione prenotazione1() {
        return new Prenotazione(LocalDate.now(), postazione1(), utente1());
    }

    @Bean
    public Prenotazione prenotazione2() {
        return new Prenotazione(LocalDate.now(), postazione1(), utente2());
    }

    @Bean
    public Prenotazione prenotazione3() {
        return new Prenotazione(LocalDate.now(), postazione2(), utente1());
    }

    @Bean
    public Prenotazione prenotazione4() {
        return new Prenotazione(LocalDate.now(), postazione3(), utente2());
    }

    @Bean
    public Prenotazione prenotazione5() {
        return new Prenotazione(LocalDate.now(), postazione1(), utente3());
    }

    @Bean
    public Prenotazione prenotazione6() {
        return new Prenotazione(LocalDate.now(), postazione1(), utente5());
    }

    @Bean
    public Prenotazione prenotazione7() {
        return new Prenotazione(LocalDate.now(), postazione1(), utente4());
    }
}
