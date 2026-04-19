package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.*;

import java.time.LocalDateTime;

public class Reunion extends Event {

    private final Lieu lieu;
    private final Participants participants;

    public Reunion(Title title,
                   Proprietaire proprietaire,
                   DateEvent date,
                   DureeMinute duree,
                   Lieu lieu,
                   Participants participants) {
        super(title, proprietaire, date, duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }

    @Override
    public boolean estDans(Periode periode) {
        return periode.contient(dateDebut);
    }

    @Override
    public Events occurencesDans(Periode periode){
        Events result = new Events();
        if(estDans(periode)){
            result.ajouter(this);
        }
        return result;
    }


    /*
    @Override
    public boolean conflitAvec(Event autre) {
        return autre.conflitAvecReunion(this);
    }
    */
}