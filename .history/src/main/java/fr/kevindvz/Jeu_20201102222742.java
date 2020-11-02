package fr.kevindvz;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.github.javafaker.Faker;

import org.apache.commons.lang3.StringUtils;

public class Jeu {

    String[] motMystere;
    String[] motMystereMasque;
    Joueur[] listeJoueur;
    int essaisRestants;
    int nbreEssais;

    private Scanner clavier;
    public String clavierEntre;
    public boolean victoire;

    public Jeu() {
        clavier = new Scanner(System.in);
        essaisRestants = 7;
        nbreEssais = 0;
        victoire = false;

    }

    public String genererMot() {
        int hasard = new Random().nextInt(5);
        String motMystereStr = "";
        switch (hasard) {
            case 0: // nom
                motMystereStr = new Faker(new Locale("fr")).name().firstName();
                break;
            case 1: // ville
                motMystereStr = new Faker(new Locale("fr")).address().city();
                break;
            case 2: // animal
                motMystereStr = new Faker(new Locale("fr")).animal().name();
                break;
            case 3:// couleurs
                motMystereStr = new Faker(new Locale("fr")).color().name();
                break;
            case 4: // nom artiste
                motMystereStr = new Faker(new Locale("fr")).artist().name();
            default:
                break;
        }
        motMystereStr = motMystereStr.toLowerCase();
        this.motMystere = motMystereStr.split("");
        return motMystereStr;
    }

    public void viderEcran() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void invitCreationJoueurs() {
        int nombreJoueurs = 1;
        boolean nombreJoueursConnu = false;
        while (nombreJoueursConnu == false) {
            System.out.println("Combien y-a-t-il de joueur ?");
            this.clavierEntre = this.clavier.next();

            try {
                nombreJoueurs = Integer.parseInt(clavierEntre);
                nombreJoueursConnu = true;
                this.listeJoueur = new Joueur[nombreJoueurs];

            } catch (Exception NumberFormatException) {
                System.out.println("erreur : Veuillez entrer un nombre entier.");
            }
        }

        for (int i = 0; i < nombreJoueurs; i++) {
            System.out.println("Joueur " + (i + 1) + ", veuillez entrer votre nom :");
            this.clavierEntre = this.clavier.next();
            this.listeJoueur[i] = new Joueur(clavierEntre);
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
        this.motMystereMasque = new String[motInArray.length];

        for (int i = 0; i < motInArray.length; i++) {
            motMystereMasque[i] = "__";

        }
    }

    public void analyserLettreRefreshAffichage() {

        boolean lettreCorrespondante = false;

        for (int i = 0; i < this.motMystere.length; i++) {
            if (motMystere[i].matches("[" + this.clavierEntre + "]")) {
                lettreCorrespondante = true;
                this.motMystereMasque[i] = motMystere[i];
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
        for (String elementAffichage : this.motMystereMasque) {
            System.out.print("  " + elementAffichage);
        }
        System.out.println(" Aide :" + StringUtils.join(this.motMystere, "") + "\n");

    }

    public void invitEssai() {

        System.out.println("Veuillez entrer une lettre :");
        this.clavierEntre = this.clavier.next();

        while (!this.clavierEntre.matches("^[a-z,é,à,è,ê,â,ô,ù]") || clavierEntre.length() != 1) {
            System.out.println("erreur : veuillez entrer une SEULE lettre en MINUSCULE de l'alphabet .");
            this.clavierEntre = this.clavier.next();
            this.nbreEssais++;
        }

    }

    public void resoudreVictoire() {
        if (Arrays.equals(this.motMystere, this.motMystereMasque)) {
            this.victoire = true;
            System.out.println("VICTOIRE !");
        }

    }

    public void afficherMessageFinPartie() {
        this.resoudreVictoire();
        if (!this.victoire) {
            System.out.println("Dommage ! Le mot n'a pas été trouvé, malgré vos " + nbreEssais + " essais...");
            System.out.println("Il fallait trouver le mot \"" + StringUtils.join(this.motMystere, "") + "\". ");
        } else {
            System.out.println("BIEN JOUE ! Vous avez bien trouvé \"" + StringUtils.join(this.motMystere, "")
                    + "\" au bout de " + nbreEssais + " essais!");
        }
    }

    public Boolean invitNouvellePartie() {
        System.out.println("Souhaitez-vous faire une nouvelle partie ? O | N");
        this.clavierEntre = this.clavier.next();
        while (!this.clavierEntre.matches("^[o,O,n,N]") || clavierEntre.length() != 1) {
            System.out.println("erreur : veuillez entre O ou N.");
            this.clavierEntre = this.clavier.next();
        }
        if (this.clavierEntre.matches("^[o,O]") == true) {
            return true;
        } else {
            return false;
        }
    }

    public void initialiserJeu() {
        essaisRestants = 7;
        nbreEssais = 0;
        victoire = false;

    }

}

// Scanner lettre = new Scanner(System.in);
// String lettreChoisie = lettre.next();
// lettre.close();
