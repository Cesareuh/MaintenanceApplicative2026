package com.maintenanceapp.Event.Props;

import java.util.Objects;

public class Title {
    private String title;

    public Title(String title){
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
