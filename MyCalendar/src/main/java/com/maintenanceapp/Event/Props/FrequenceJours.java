package com.maintenanceapp.Event.Props;

public final class FrequenceJours {

    private final int value;

    public FrequenceJours(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Frequency must be > 0");
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof FrequenceJours other)
                && value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}