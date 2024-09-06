package com.example.Spring1D5;

import com.example.Spring1D5.entities.Edificio;
import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.enums.TipoPostazione;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.PrenotazioneRepository;
import com.example.Spring1D5.services.EdificioService;
import com.example.Spring1D5.services.PostazioneService;
import com.example.Spring1D5.services.PrenotazioniService;
import com.example.Spring1D5.services.UtenteService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioniService prenotazioniService;
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private Utente utente1;
    @Autowired
    private Utente utente2;
    @Autowired
    private Utente utente3;
    @Autowired
    private Utente utente4;
    @Autowired
    private Utente utente5;

    @Autowired
    private Postazione postazione1;
    @Autowired
    private Postazione postazione2;
    @Autowired
    private Postazione postazione3;

    @Autowired
    private Prenotazione prenotazione1;
    @Autowired
    private Prenotazione prenotazione2;
    @Autowired
    private Prenotazione prenotazione3;
    @Autowired
    private Prenotazione prenotazione4;
    @Autowired
    private Prenotazione prenotazione5;
    @Autowired
    private Prenotazione prenotazione6;
    @Autowired
    private Prenotazione prenotazione7;

    @Autowired
    private Edificio edificio1;
    @Autowired
    private Edificio edificio2;
    @Autowired
    private Edificio edificio3;


    @Override
    public void run(String... args) throws Exception {


//        Faker faker = new Faker(Locale.ITALY);
//
//        Edificio edificio1 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
//        Edificio edificio2 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
//        Edificio edificio3 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
//
//        Postazione postazione1 = new Postazione("Postazione privata con vista", TipoPostazione.PRIVATO, 1, edificio1);
//        Postazione postazione2 = new Postazione("Postazione open space", TipoPostazione.OPENSPACE, 5, edificio2);
//        Postazione postazione3 = new Postazione("Sala riunioni grande", TipoPostazione.SALA_RIUNIONI, 10, edificio3);
//
//        Utente utente1 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
//        Utente utente2 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
//        Utente utente3 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
//        Utente utente4 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
//        Utente utente5 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
//
//        List<Utente> listaUtenti = new ArrayList<>();
//        listaUtenti.add(utente1);
//        listaUtenti.add(utente2);
//        listaUtenti.add(utente3);
//        listaUtenti.add(utente4);
//        listaUtenti.add(utente5);
//
//        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(), postazione1, utente1);
//        Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(), postazione1, utente2);
//        Prenotazione prenotazione3 = new Prenotazione(LocalDate.now(), postazione2, utente1);
//        Prenotazione prenotazione4 = new Prenotazione(LocalDate.now(), postazione3, utente2);
//        Prenotazione prenotazione5 = new Prenotazione(LocalDate.now(), postazione1, utente3);
//        Prenotazione prenotazione6 = new Prenotazione(LocalDate.now(), postazione1, utente5);
//        Prenotazione prenotazione7 = new Prenotazione(LocalDate.now(), postazione1, utente4);
//
//        List<Prenotazione> listaPrenotazioni = new ArrayList<>();
//        listaPrenotazioni.add(prenotazione1);
//        listaPrenotazioni.add(prenotazione2);
//        listaPrenotazioni.add(prenotazione3);
//        listaPrenotazioni.add(prenotazione4);
//        listaPrenotazioni.add(prenotazione5);
//        listaPrenotazioni.add(prenotazione6);
//        listaPrenotazioni.add(prenotazione7);

        List<Utente> listaUtenti = new ArrayList<>();
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        listaUtenti.add(utente5);

        // salvataggio utenti
        try {
            for (int i = 0; i < listaUtenti.size(); i++) {
                utenteService.saveUtente(listaUtenti.get(i));
            }
        } catch (ValidException ex) {
            System.out.println(ex.getMessage());
        }

        List<Edificio> listaEdificio = new ArrayList<>();
        listaEdificio.add(edificio1);
        listaEdificio.add(edificio2);
        listaEdificio.add(edificio3);

        // salvataggio edifici
        try {
            for (int i = 0; i < listaEdificio.size(); i++) {
                edificioService.saveEdificio(listaEdificio.get(i));
            }
        } catch (ValidException ex) {
            System.out.println(ex.getMessage());
        }

        List<Postazione> listaPostazioni = new ArrayList<>();
        listaPostazioni.add(postazione1);
        listaPostazioni.add(postazione2);
        listaPostazioni.add(postazione3);

        // salvataggio postazioni
        try {
            for (int i = 0; i < listaPostazioni.size(); i++) {
                postazioneService.savePostazione(listaPostazioni.get(i));
            }
        } catch (ValidException ex) {
            System.out.println(ex.getMessage());
        }

        List<Prenotazione> listaPrenotazioni = new ArrayList<>();
        listaPrenotazioni.add(prenotazione1);
        listaPrenotazioni.add(prenotazione2);
        listaPrenotazioni.add(prenotazione3);
        listaPrenotazioni.add(prenotazione4);
        listaPrenotazioni.add(prenotazione5);
        listaPrenotazioni.add(prenotazione6);
        listaPrenotazioni.add(prenotazione7);

        // salvataggio prenotazione
        try {
            for (int i = 0; i < listaPrenotazioni.size(); i++) {
                prenotazioniService.savePrenotazione(listaPrenotazioni.get(i));
            }
        } catch (ValidException ex) {
            System.out.println(ex.getMessage());
        }

        // salvataggio utenti
//        try {
//            for (int i = 0; i < listaUtenti.size(); i++) {
//                utenteService.saveUtente(listaUtenti.get(i));
//            }
//        } catch (ValidException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println("Numero di utenti nel database:");
//        System.out.println(utenteService.count());

        //salvataggio postazioni
//        try {
//            .saveUser(newUser);
//        } catch (ValidationException ex) {
//            System.out.println(ex.getMessage());
//        }

        // salvataggio prenotazioni


    }
}


