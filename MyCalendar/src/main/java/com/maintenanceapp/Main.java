package com.maintenanceapp;

import com.maintenanceapp.Event.*;
import com.maintenanceapp.Event.Props.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        String utilisateur = null;

        while (true) {

            if (utilisateur == null) {
                System.out.println("Connexion...");
                System.out.print("Utilisateur : ");
                utilisateur = scanner.nextLine();
            }

            while (utilisateur != null) {

                System.out.println("\n=== MENU ===");
                System.out.println("1 - Voir événements");
                System.out.println("2 - Ajouter RDV");
                System.out.println("3 - Ajouter réunion");
                System.out.println("4 - Ajouter périodique");
                System.out.println("5 - Supprimer événement");
                System.out.println("6 - Voir conflits");
                System.out.println("7 - Logout");

                String choix = scanner.nextLine();

                switch (choix) {

                    case "1" -> afficher(calendar.tousLesEvenements());

                    case "2" -> {

                        Event rdv = new RdvPerso(
                                new Title(lire(scanner, "Titre")),
                                new Proprietaire(utilisateur),
                                new DateEvent(lireDate(scanner)),
                                new DureeMinute(lireInt(scanner, "Durée"))
                        );

                        calendar.ajouterEvent(rdv);
                    }

                    case "3" -> {

                        Participants participants = new Participants();
                        participants.ajouter(new Participant(utilisateur));

                        Event reunion = new Reunion(
                                new Title(lire(scanner, "Titre")),
                                new Proprietaire(utilisateur),
                                new DateEvent(lireDate(scanner)),
                                new DureeMinute(lireInt(scanner, "Durée")),
                                new Lieu(lire(scanner, "Lieu")),
                                participants
                        );

                        calendar.ajouterEvent(reunion);
                    }

                    case "4" -> {

                        Event periodique = new Periodique(
                                new Title(lire(scanner, "Titre")),
                                new Proprietaire(utilisateur),
                                new DateEvent(lireDate(scanner)),
                                new DureeMinute(lireInt(scanner, "Durée")),
                                new FrequenceJours(lireInt(scanner, "Fréquence jours"))
                        );

                        calendar.ajouterEvent(periodique);
                    }

                    case "5" -> {

                        System.out.print("EventId à supprimer : ");
                        String id = scanner.nextLine();

                        calendar.supprimer(new EventId(id));
                    }

                    case "6" -> {

                        System.out.println("Début période : ");
                        LocalDateTime debut = lireDate(scanner);

                        System.out.println("Fin période : ");
                        LocalDateTime fin = lireDate(scanner);

                        Periode periode = new Periode(debut, fin);

                        Events conflits = calendar.detecterConflits(periode);

                        System.out.println("Conflits : ");
                        afficher(conflits);
                    }

                    case "7" -> utilisateur = null;
                }
            }
        }
    }

    private static LocalDateTime lireDate(Scanner scanner) {
        System.out.print("Année : ");
        int y = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois : ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour : ");
        int d = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure : ");
        int h = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute : ");
        int min = Integer.parseInt(scanner.nextLine());

        return LocalDateTime.of(y, m, d, h, min);
    }

    private static String lire(Scanner scanner, String label) {
        System.out.print(label + " : ");
        return scanner.nextLine();
    }

    private static int lireInt(Scanner scanner, String label) {
        System.out.print(label + " : ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void afficher(Events events) {
        for (Event e : events.value()) {
            System.out.println("- " + e.description());
        }
    }
}