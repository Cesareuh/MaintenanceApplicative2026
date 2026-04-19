package com.maintenanceapp.Event.Props;

import java.util.Objects;

public final class Participant {

    private final String value;

    public Participant(String value) {
        this.value = Objects.requireNonNull(value);

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Participant cannot be empty");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Participant other)
                && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}