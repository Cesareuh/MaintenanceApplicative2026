package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.*;

public abstract class Event {

    public final Title title;
    public final Proprietaire proprietaire;
    public final DateEvent dateDebut;
    public final DureeMinute duree;

    protected Event(Title title,
                    Proprietaire proprietaire,
                    DateEvent date,
                    DureeMinute duree) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = date;
        this.duree = duree;
    }

    public abstract String description();

    public abstract boolean estDans(Periode periode);

    public abstract Events occurencesDans(Periode periode);

    // public abstract boolean conflitAvec(Event autre);
}