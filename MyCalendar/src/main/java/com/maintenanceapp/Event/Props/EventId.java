package com.maintenanceapp.Event.Props;

import java.util.Objects;
import java.util.UUID;

public final class EventId {

    private final String value;

    public EventId() {
        this.value = UUID.randomUUID().toString();
    }

    public EventId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventId)) return false;
        EventId eventId = (EventId) o;
        return Objects.equals(value, eventId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}