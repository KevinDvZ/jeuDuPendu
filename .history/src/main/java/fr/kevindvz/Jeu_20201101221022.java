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

    public void viderEcran() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void ecranBienvenue() {

        System.out.println("Bienvenue dans le jeu du pendu. Combien y-a-t-il de joueur ?");
        Scanner clavier = new Scanner(System.in);
        String clavierEntre = clavier.next();
        clavier.close();
        try {
            int nombreJoueurs = Integer.parseInt(clavierEntre);
        } catch (Exception e) {
            System.out.println("Je ne suis pas un entier, et alors ca te derange ?");
        }

    }

    // Scanner lettre = new Scanner(System.in);
    // String lettreChoisie = lettre.next();
    // lettre.close();
}
