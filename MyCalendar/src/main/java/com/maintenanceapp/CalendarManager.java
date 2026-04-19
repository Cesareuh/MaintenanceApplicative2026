package com.maintenanceapp;
import com.maintenanceapp.Event.Event;
import com.maintenanceapp.Event.Events;
import com.maintenanceapp.Event.Props.EventId;
import com.maintenanceapp.Event.Props.Periode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    // public List<Event> events;
    public Events events;

    public CalendarManager() {
        events = new Events();
    }

    /*
    public void ajouterEvent(String type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                             String lieu, String participants, int frequenceJours) {
        Event e = new Event(type, title, proprietaire, dateDebut, dureeMinutes, lieu, participants, frequenceJours);
        events.add(e);
    }
    */

    public void ajouterEvent(Event e){
        events.ajouter(e);
    }

    /*
    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.type.equals("PERIODIQUE")) {
                LocalDateTime temp = e.dateDebut;
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours);
                }
            } else if (!e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }
    */
    public Events eventsDansPeriode(Periode periode) {
        return events.dansPeriode(periode);
    }

    public Events tousLesEvenements() {
        Events result = new Events();
        result.ajouterTous(this.events);
        return result;
    }

    public void supprimer(EventId id) {
        events.value().removeIf(e -> e.id.equals(id));
    }

    public Events detecterConflits(Periode periode) {
        return events.dansPeriode(periode).conflits();
    }
    /*
    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.dateDebut.plusMinutes(e1.dureeMinutes);
        LocalDateTime fin2 = e2.dateDebut.plusMinutes(e2.dureeMinutes);

        if (e1.type.equals("PERIODIQUE") || e2.type.equals("PERIODIQUE")) {
            return false; // Simplification abusive
        }

        if (e1.dateDebut.isBefore(fin2) && fin1.isAfter(e2.dateDebut)) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
    */
}