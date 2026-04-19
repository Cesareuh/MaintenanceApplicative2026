package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.*;

import java.time.LocalDateTime;

public abstract class Event {

    public final EventId id;
    public final Title title;
    public final Proprietaire proprietaire;
    public final DateEvent dateDebut;
    public final DureeMinute duree;

    protected Event(
                    Title title,
                    Proprietaire proprietaire,
                    DateEvent date,
                    DureeMinute duree) {
        this.id = new EventId();
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = date;
        this.duree = duree;
    }

    public abstract String description();

    public abstract boolean estDans(Periode periode);

    public abstract Events occurencesDans(Periode periode);

    public Interval interval() {
        LocalDateTime start = dateDebut.value();
        LocalDateTime end = start.plusMinutes(duree.value());

        return new Interval(start, end);
    }

    public boolean conflitAvec(Event other) {
        return interval().chevauche(other.interval());
    }

    // public abstract boolean conflitAvec(Event autre);
}