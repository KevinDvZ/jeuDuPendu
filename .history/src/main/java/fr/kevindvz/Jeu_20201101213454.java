package fr.kevindvz;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Jeu {

    String motMystere;
    ArrayList<Joueur> listeJoueur;

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

    // Scanner lettre = new Scanner(System.in);
    // String lettreChoisie = lettre.next();
    // lettre.close();
}
