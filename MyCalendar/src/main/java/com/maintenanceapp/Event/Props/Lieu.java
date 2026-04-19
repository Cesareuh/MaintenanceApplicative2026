package com.maintenanceapp.Event.Props;

import java.util.Objects;

public final class Lieu {

    private final String value;

    public Lieu(String value) {
        this.value = Objects.requireNonNull(value);

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Lieu cannot be empty");
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
        return (o instanceof Lieu other)
                && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}