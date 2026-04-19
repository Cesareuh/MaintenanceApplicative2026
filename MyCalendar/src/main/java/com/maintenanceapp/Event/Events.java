package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.Periode;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private final List<Event> events;

    public Events(){
        events = new ArrayList<>();
    }

    public void ajouter(Event e){
        events.add(e);
    }

    public void ajouterTous(Events events) {
        for(Event e : events.value()){
            ajouter(e);
        }
    }

    public Events dansPeriode(Periode periode){
        Events result = new Events();
        for(Event e : events){
            result.ajouterTous(e.occurencesDans(periode));
        }
        return result;
    }

    public int size(){
        return events.size();
    }

    public List<Event> value(){
        return events;
    }
}
