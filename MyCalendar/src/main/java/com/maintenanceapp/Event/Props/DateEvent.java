package com.maintenanceapp.Event.Props;

import java.time.LocalDateTime;

public final class DateEvent {

    private final LocalDateTime value;

    public DateEvent(LocalDateTime value) {
        this.value = value;
    }

    public boolean chevauche(DateEvent autre, DureeMinute d1, DureeMinute d2) {
        LocalDateTime fin1 = value.plusMinutes(d1.value());
        LocalDateTime fin2 = autre.value.plusMinutes(d2.value());

        return value.isBefore(fin2) && autre.value.isBefore(fin1);
    }

    public LocalDateTime value() {
        return value;
    }
}