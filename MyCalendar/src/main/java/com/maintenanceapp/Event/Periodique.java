package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.*;

public class Periodique extends Event {

    public final FrequenceJours frequenceJours;

    public Periodique(Title title,
                      Proprietaire proprietaire,
                      DateEvent date,
                      DureeMinute duree,
                      FrequenceJours frequenceJours) {
        super(title, proprietaire, date, duree);
        this.frequenceJours = frequenceJours;
    }
    public Periodique(Periodique event) {
        super(event.title, event.proprietaire, event.dateDebut, event.duree);
        this.frequenceJours = event.frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }

    @Override
    public boolean estDans(Periode periode) {
        return periode.contient(dateDebut);
    }

    @Override
    public Events occurencesDans(Periode periode) {

        Events result = new Events();

        DateEvent temp = new DateEvent(dateDebut.value());

        while (!temp.value().isAfter(periode.fin())) {

            if (!temp.value().isBefore(periode.debut())) {
                result.ajouter(new RdvPerso(
                        title,
                        proprietaire,
                        temp,
                        duree
                ));
            }

            temp = new DateEvent(
                    temp.value().plusDays(frequenceJours.value())
            );
        }

        return result;
    }}