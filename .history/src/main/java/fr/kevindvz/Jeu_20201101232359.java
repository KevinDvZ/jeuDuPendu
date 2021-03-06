package fr.kevindvz;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Jeu {

    String motMystere;
    Joueur[] listeJoueur;
    int nombreJoueurs;
    private Scanner clavier;
    private String clavierEntre;

    public Jeu() {
        this.nouveauMot();
    }

    public String nouveauMot() {
        int hasard = new Random().nextInt(5);
        switch (hasard) {
            case 0: // nom

                motMystere = new Faker(new Locale("fr")).name().firstName();
                break;
            case 1: // ville
                motMystere = new Faker(new Locale("fr")).address().city();
                break;
            case 2: // animal
                motMystere = new Faker(new Locale("fr")).animal().name();
                break;
            case 3:// couleurs
                motMystere = new Faker(new Locale("fr")).color().name();
                break;
            case 4: // nom artiste
                motMystere = new Faker(new Locale("fr")).artist().name();
            default:
                break;
        }
        return motMystere;
    }

    public void viderEcran() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public boolean ecranChoixJoueur() {
        boolean nombreJoueursConnu = false;
        System.out.println("Combien y-a-t-il de joueur ?");
        clavier = new Scanner(System.in);
        String clavierEntre = clavier.next();

        try {
            nombreJoueurs = Integer.parseInt(clavierEntre);
            nombreJoueursConnu = true;
        } catch (Exception NumberFormatException) {
            System.out.println("erreur : Veuillez entrer un nombre entier.");
        }
        return nombreJoueursConnu;
    }

    public void ecranCreationJoueurs() {
        listeJoueur = new Joueur[nombreJoueurs];
        clavier = new Scanner(System.in);
        int i = 1;
        for (Joueur j : listeJoueur) {
            System.out.println("Joueur " + i + ", veuillez entrer votre nom :");
            this.clavierEntre = clavier.nextLine();
            j.nom = clavierEntre;
        }
    }
}

// Scanner lettre = new Scanner(System.in);
// String lettreChoisie = lettre.next();
// lettre.close();
