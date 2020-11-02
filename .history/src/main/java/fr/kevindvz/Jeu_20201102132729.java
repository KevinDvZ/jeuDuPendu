package fr.kevindvz;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.github.javafaker.Faker;

public class Jeu {

    String motMystere;
    String[] motMystereAffichage;
    Joueur[] listeJoueur;
    int nombreJoueurs;
    int essaisRestants;
    boolean jeuInitialisé;
    private Scanner clavier;
    private String clavierEntre;

    public Jeu() {
        clavier = new Scanner(System.in);
        essaisRestants = 9;
        jeuInitialisé = false;
    }

    public String genererMot() {
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

    public void invitNombreJoueurs() {
        boolean nombreJoueursConnu = false;
        while (nombreJoueursConnu == false) {
            System.out.println("Combien y-a-t-il de joueur ?");
            this.clavierEntre = this.clavier.next();

            try {
                nombreJoueurs = Integer.parseInt(clavierEntre);
                nombreJoueursConnu = true;
            } catch (Exception NumberFormatException) {
                System.out.println("erreur : Veuillez entrer un nombre entier.");
            }
        }
    }

    public void invitCreationJoueurs() {
        listeJoueur = new Joueur[nombreJoueurs];
        for (int i = 0; i < nombreJoueurs; i++) {
            System.out.println("Joueur " + (i + 1) + ", veuillez entrer votre nom :");
            this.clavierEntre = this.clavier.next();
            listeJoueur[i] = new Joueur(clavierEntre);
            i++;
        }
    }

    public void afficherDessinPendu() {
        if (essaisRestants == 0) {
            System.out.println("DOMMAGE !\n\n");
        }
        System.out.println("     |--|     ");
        if (essaisRestants == 7) {
            System.out.println("        |     ");
        } else {
            System.out.println("     O  |     ");
        }
        if (essaisRestants >= 6) {
            System.out.println("        |     ");
        }
        if (essaisRestants == 5) {
            System.out.println("     |  |     ");
        }
        if (essaisRestants == 4) {
            System.out.println("    /|  |     ");
        }
        if (essaisRestants <= 3) {
            System.out.println("    /|\\ |     ");
        }
        if (essaisRestants > 2) {
            System.out.println("        |     ");
        }
        if (essaisRestants <= 2) {
            System.out.println("     -  |     ");
        }
        if (essaisRestants == 1) {
            System.out.println("    /   |     ");
        }
        if (essaisRestants == 0) {
            System.out.println("    / \\ |     ");
        }
        System.out.println("        |     ");
        System.out.println("     ------   ");

    }

    public void initMotMystere() {

        if (this.jeuInitialisé == false) {
            String[] motInArray = this.genererMot().split("");
            this.motMystereAffichage = new String[motInArray.length];

            for (int i = 0; i < motInArray.length; i++) {
                motMystereAffichage[i] = "__";
            }
            this.jeuInitialisé = true;
        } else {
            this.traiterEntreeActualiserAffichageMot();
        }
    }

    private void traiterEntreeActualiserAffichageMot() {

    }

    public void afficherMotMystere() {
        for (String elementAffichage : this.motMystereAffichage) {
            System.out.println("  " + elementAffichage);
        }

    }

    public void invitEssai() {

        System.out.println("Veuillez entrer une lettre :");
        this.clavierEntre = this.clavier.next();

        while (this.clavierEntre.matches("^[a-zA-Z]") == false && clavierEntre.length() != 1) {

            System.out.println("erreur : veuillez entrer une SEULE lettre de l'alphabet.");
            this.clavierEntre = this.clavier.next();
        }
        System.out.println("OK");
        System.out.println(this.clavierEntre.matches("^[a-zA-Z]"));
    }
}

// Scanner lettre = new Scanner(System.in);
// String lettreChoisie = lettre.next();
// lettre.close();
