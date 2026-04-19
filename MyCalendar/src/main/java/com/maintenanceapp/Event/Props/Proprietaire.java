package com.maintenanceapp.Event.Props;

import java.util.Objects;

public class Proprietaire {
    private String proprietaire;

    public Proprietaire(String proprietaire){
        this.proprietaire = proprietaire;
    }

    public String value(){
        return proprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proprietaire that = (Proprietaire) o;
        return Objects.equals(proprietaire, that.proprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(proprietaire);
    }

    @Override
    public String toString() {
        return proprietaire;
    }
}
