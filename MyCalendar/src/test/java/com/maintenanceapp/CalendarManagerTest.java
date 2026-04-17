package com.maintenanceapp;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarManagerTest {
    public CalendarManager cal;

    @BeforeEach
    void init(){
        cal = new CalendarManager();
    }

    @Test
    void addRdvPerso(){
        cal.ajouterEvent(new RdvPerso(
                new Title("test"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.now()),
                new DureeMinute(20)
        ));

        assertEquals(1, cal.events.size());
    }
    @Test
    void addReunion(){
        Participants participants = new Participants();
        participants.ajouter(new Participant("Alice"));
        participants.ajouter(new Participant("Bob"));

        cal.ajouterEvent(new Reunion(
                new Title("test"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.now()),
                new DureeMinute(20),
                new Lieu("ici"),
                participants
        ));

        assertEquals(1, cal.events.size());
    }
    @Test
    void addPeriodique(){
        cal.ajouterEvent(new Periodique(
                new Title("test"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.now()),
                new DureeMinute(20),
                new FrequenceJours(7)
        ));

        assertEquals(1, cal.events.size());
    }

    private void setupEvents(){
        cal.ajouterEvent(new Periodique(
                new Title("period"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.of(2026, 5, 10, 0, 0)),
                new DureeMinute(20),
                new FrequenceJours(7)
        ));

        cal.ajouterEvent(new RdvPerso(
                new Title("perso1"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.of(2026, 5, 10, 0, 0)),
                new DureeMinute(20)
        ));

        cal.ajouterEvent(new RdvPerso(
                new Title("perso2"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.of(2026, 5, 17, 0, 0)),
                new DureeMinute(20)
        ));

        cal.ajouterEvent(new RdvPerso(
                new Title("perso3"),
                new Proprietaire("Jean"),
                new DateEvent(LocalDateTime.of(2026, 5, 18, 0, 0)),
                new DureeMinute(20)
        ));

    }

    @Test
    void getPeriodEvent(){
        setupEvents();

        Events events = cal.eventsDansPeriode(
                LocalDateTime.of(2026, 4, 1, 0, 0),
                LocalDateTime.of(2026, 5, 20, 0, 0)
        );

        assertEquals(5, events.size());


    }

    @Test
    void getEvents(){
        Events events = cal.eventsDansPeriode(
                LocalDateTime.of(2026, 5, 1, 0, 0),
                LocalDateTime.of(2026, 5, 10, 0, 0)
        );
        assertEquals(2, events.size());
    }

    @Test
    void getEvents2() {
        Events events = cal.eventsDansPeriode(
                LocalDateTime.of(2026, 5, 15, 0, 0),
                LocalDateTime.of(2026, 5, 18, 0, 0)
        );
        assertEquals(3, events.size());
    }
}