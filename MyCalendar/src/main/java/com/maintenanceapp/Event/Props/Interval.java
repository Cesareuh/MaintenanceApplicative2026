package com.maintenanceapp.Event.Props;

import java.time.LocalDateTime;

public class Interval {

    private final LocalDateTime debut;
    private final LocalDateTime fin;

    public Interval(LocalDateTime debut, LocalDateTime fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public LocalDateTime debut() {
        return debut;
    }

    public LocalDateTime fin() {
        return fin;
    }

    public boolean chevauche(Interval other) {
        return !(fin.isBefore(other.debut()) || debut.isAfter(other.fin()));
    }
}