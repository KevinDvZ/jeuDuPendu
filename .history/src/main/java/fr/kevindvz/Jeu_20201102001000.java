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
    int essaisRestants;
    private Scanner clavier;
    private String clavierEntre;

    public Jeu() {
        this.nouveauMot();
        clavier = new Scanner(System.in);
        essaisRestants = 5;
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
        this.clavierEntre = this.clavier.next();

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
        for (int i = 0; i < nombreJoueurs; i++) {
            System.out.println("Joueur " + (i + 1) + ", veuillez entrer votre nom :");
            this.clavierEntre = this.clavier.next();
            listeJoueur[i] = new Joueur(clavierEntre);
            i++;
        }
    }

    public void afficherDessinPendu() {
        System.out.println("     |--|     ");
        if (essaisRestants == 5) {
            System.out.println("        |     ");
        } else {
            System.out.println("     O  |     ");
        }
        System.out.println("    /|\\ |     ");
        System.out.println("     -  |     ");
        System.out.println("    / \\ |     ");
        System.out.println("        |     ");
        System.out.println("     ------   ");
    }
}

// Scanner lettre = new Scanner(System.in);
// String lettreChoisie = lettre.next();
// lettre.close();
