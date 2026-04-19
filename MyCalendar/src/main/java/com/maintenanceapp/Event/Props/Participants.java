package com.maintenanceapp.Event.Props;

import java.util.ArrayList;
import java.util.List;

public final class Participants {

    private final List<Participant> list;

    public Participants() {
        this.list = new ArrayList<>();
    }

    public void ajouter(Participant p) {
        list.add(p);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}