package fr.kevindvz;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

public class Jeu {

    String motMystere;
    String[] motMystereAffichage;
    Joueur[] listeJoueur;
    int essaisRestants;

    private Scanner clavier;
    public String clavierEntre;
    public boolean victoire;

    public Jeu() {
        clavier = new Scanner(System.in);
        essaisRestants = 7;
        victoire = false;

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

    // public void invitNombreJoueurs() {

    public void invitCreationJoueurs() {

        while (nombreJoueursConnu == false) {
            System.out.println("Combien y-a-t-il de joueur ?");
            this.clavierEntre = this.clavier.next();

            try {
                int nombreJoueurs = Integer.parseInt(clavierEntre);
                nombreJoueursConnu = true;
            } catch (Exception NumberFormatException) {
                System.out.println("erreur : Veuillez entrer un nombre entier.");
            }
        }

        for (int i = 0; i < this.listeJoueur.length; i++) {
            System.out.println("Joueur " + (i + 1) + ", veuillez entrer votre nom :");
            this.clavierEntre = this.clavier.next();
            listeJoueur[i] = new Joueur(clavierEntre);
            i++;
        }
    }

    public void afficherJoueurs() {
        System.out.println("Liste des participant :");
        System.out.println("");
    }

    public void afficherDessinPendu() {
        if (essaisRestants == 0) {
            System.out.println("     DOMMAGE ! C'EST PERDU.\n\n");
        }
        System.out.println("     |--|     ");
        if (essaisRestants == 7) {
            System.out.println("        |     ");
        }
        if (essaisRestants <= 6) {
            System.out.println("     O  |     ");
        }
        if (essaisRestants >= 6) {
            System.out.println("        |     ");
        }
        if (essaisRestants == 5) {
            System.out.println("     |  |     ");
        }
        if (essaisRestants == 4) {
            System.out.println("    \\|  |     ");
        }
        if (essaisRestants <= 3) {
            System.out.println("    \\|/ |     ");
        }
        if (essaisRestants > 2) {
            System.out.println("        |     ");
        }

        if (essaisRestants <= 2) {
            System.out.println("     -  |     ");
        }
        if (essaisRestants > 2) {
            System.out.println("        |     ");
        }
        if (essaisRestants == 2) {
            System.out.println("    /   |     ");
        }
        if (essaisRestants <= 1) {
            System.out.println("    / \\ |     ");
        }
        System.out.println("        |     ");
        System.out.println("     ------   ");

    }

    public void initMotMasque() {

        String[] motInArray = this.genererMot().split("");
        this.motMystereAffichage = new String[motInArray.length];

        for (int i = 0; i < motInArray.length; i++) {
            motMystereAffichage[i] = "__";

        }
    }

    public void analyserLettreRefreshAffichage() {
        String[] motInArray = this.motMystere.split("");
        boolean lettreCorrespondante = false;

        for (int i = 0; i < motInArray.length; i++) {
            if (motInArray[i].matches("[" + this.clavierEntre + "]")) {
                lettreCorrespondante = true;
                this.motMystereAffichage[i] = motInArray[i];
            }
        }
        if (lettreCorrespondante == true) {
            System.out.println("Bravo, une lettre de plus trouvée !\n");
        } else {
            this.essaisRestants--;
            System.out.println("Perdu! Essayez encore.Plus que " + this.essaisRestants + " essais.\n");
        }
    }

    public void afficherMotMasque() {
        for (String elementAffichage : this.motMystereAffichage) {
            System.out.print("  " + elementAffichage);
        }
        // System.out.println(" aide :" + this.motMystere + "\n");

    }

    public void invitEssai() {

        System.out.println("Veuillez entrer une lettre :");
        this.clavierEntre = this.clavier.next();

        while (!this.clavierEntre.matches("^[a-z]") || clavierEntre.length() != 1) {
            System.out.println("erreur : veuillez entrer une SEULE lettre en MINUSCULE de l'alphabet .");
            this.clavierEntre = this.clavier.next();
        }

    }

    public void resoudreVictoire{
if this.
    }

    public void afficherMessageFinPartie() {
        if (this.essaisRestants == 0 && !this.victoire) {

        }
    }

}

// Scanner lettre = new Scanner(System.in);
// String lettreChoisie = lettre.next();
// lettre.close();
