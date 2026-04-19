package com.maintenanceapp.Event.Props;

import com.maintenanceapp.Event.Event;
import com.maintenanceapp.Event.Periodique;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Periode {

    private final LocalDateTime debut;
    private final LocalDateTime fin;

    public Periode(LocalDateTime debut, LocalDateTime fin) {
        this.debut = Objects.requireNonNull(debut);
        this.fin = Objects.requireNonNull(fin);

        if (fin.isBefore(debut)) {
            throw new IllegalArgumentException("Fin must be after debut");
        }
    }

    public boolean contient(DateEvent date) {
        LocalDateTime value = date.value();

        return (value.isEqual(debut) || value.isAfter(debut))
                && (value.isEqual(fin) || value.isBefore(fin));
    }

    public boolean contientOccurence(Periodique e) {
        DateEvent dateTemp = new DateEvent(e.dateDebut.value());
        while(dateTemp.value().isBefore(debut())){
            dateTemp = new DateEvent(dateTemp.value().plusDays(e.frequenceJours.value()));
        }
        return !dateTemp.value().isAfter(fin());
    }

    public boolean chevauche(Periode autre) {
        return !fin.isBefore(autre.debut)
                && !autre.fin.isBefore(debut);
    }

    public LocalDateTime debut() {
        return debut;
    }

    public LocalDateTime fin() {
        return fin;
    }
}