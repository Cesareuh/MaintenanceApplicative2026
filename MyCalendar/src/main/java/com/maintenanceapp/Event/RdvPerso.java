package com.maintenanceapp.Event;

import com.maintenanceapp.Event.Props.*;

public class RdvPerso extends Event {

    public RdvPerso(Title title,
                    Proprietaire proprietaire,
                    DateEvent date,
                    DureeMinute duree) {
        super(title, proprietaire, date, duree);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }

    @Override
    public boolean estDans(Periode periode) {
        return periode.contient(dateDebut);
    }

    @Override
    public Events occurencesDans(Periode periode){
        Events result = new Events();
        if(estDans(periode)){
            result.ajouter(this);
        }
        return result;
    }

    /*
    @Override
    public boolean conflitAvec(Event autre) {
        return autre.conflitAvecRdv(this);
    }

    public boolean conflitAvecRdv(RdvPerso autre) {
        return dateDebut.chevauche(autre.dateDebut, duree, autre.duree);
    }
    */
}