package com.example.Spring1D5;

import com.example.Spring1D5.entities.Edificio;
import com.example.Spring1D5.entities.Postazione;
import com.example.Spring1D5.entities.Prenotazione;
import com.example.Spring1D5.entities.Utente;
import com.example.Spring1D5.enums.TipoPostazione;
import com.example.Spring1D5.exceptions.ValidException;
import com.example.Spring1D5.repositories.PrenotazioneRepository;
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
    private PrenotazioneRepository prenotazioneRepository;


    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(Locale.ITALY);

        Edificio edificio1 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
        Edificio edificio2 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");
        Edificio edificio3 = new Edificio(faker.company().name(), faker.address().streetAddress(), "Milano");

        Postazione postazione1 = new Postazione("Postazione privata con vista", TipoPostazione.PRIVATO, 1, edificio1);
        Postazione postazione2 = new Postazione("Postazione open space", TipoPostazione.OPENSPACE, 5, edificio2);
        Postazione postazione3 = new Postazione("Sala riunioni grande", TipoPostazione.SALA_RIUNIONI, 10, edificio3);

        Utente utente1 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
        Utente utente2 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
        Utente utente3 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
        Utente utente4 = new Utente(faker.name().lastName(), faker.internet().emailAddress());
        Utente utente5 = new Utente(faker.name().lastName(), "ausonio.orlando@gmail.com");


        List<Utente> listaUtenti = new ArrayList<>();
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        listaUtenti.add(utente5);

        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(), postazione1, utente1);
        Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(), postazione1, utente2);
        Prenotazione prenotazione3 = new Prenotazione(LocalDate.now(), postazione2, utente1);
        Prenotazione prenotazione4 = new Prenotazione(LocalDate.now(), postazione3, utente2);
        Prenotazione prenotazione5 = new Prenotazione(LocalDate.now(), postazione1, utente3);
        Prenotazione prenotazione6 = new Prenotazione(LocalDate.now(), postazione1, utente5);
        Prenotazione prenotazione7 = new Prenotazione(LocalDate.now(), postazione1, utente4);

        try {
            for (int i = 0; i < listaUtenti.size(); i++) {
                utenteService.saveUtente(listaUtenti.get(i));
            }
        } catch (ValidException ex) {
            System.out.println(ex.getMessage());
        }

//        utenteService.findAll().forEach(System.out::println);


//    usersService.findAll().forEach(System.out::println);
//
//    try {
//        System.out.println(usersService.findById(11));
//    } catch (NotFoundException ex) {
//        System.out.println(ex.getMessage());
//    }
//
//    try {
//        usersService.findByIdAndDelete(11);
//    } catch (NotFoundException ex) {
//        System.out.println(ex.getMessage());
//    }
//
//    try {
//        usersService.findByIdAndUpdate(12, new User("Aldo", "Baglio", "aldo@baglio.it", 5));
//    } catch (NotFoundException ex) {
//        System.out.println(ex.getMessage());
//    }
//
//    System.out.println("Numero di utenti nel DB");
//    System.out.println(usersService.count());
//
//    System.out.println("------------------------------------------------- QUERIES ------------------------------------------------");
//    // usersService.findMaggiorenni().forEach(System.out::println);
//    // usersService.findBySurname("Baglio").forEach(System.out::println);
//    // usersService.findByNameAndSurname("Gollum", "Baglio").forEach(System.out::println);
//    // usersService.findByPartialName("al").forEach(System.out::println);
//	/*	List<String> names = new ArrayList<>();
//		names.add("Aldo");
//		names.add("Aragorn");
//		names.add("Gollum");
//		usersService.findByListaDiNomi(names).forEach(System.out::println);*/
//    // usersService.findMinorenni().forEach(System.out::println);
//    usersService.findSenzaCognome().forEach(System.out::println);


    }

}
