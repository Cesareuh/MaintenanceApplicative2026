package com.maintenanceapp.Event.Props;

public final class DureeMinute {

    private final Integer value;

    public DureeMinute(Integer value) {
        if (value <= 0) throw new IllegalArgumentException();
        this.value = value;
    }

    public Integer value() {
        return value;
    }
}