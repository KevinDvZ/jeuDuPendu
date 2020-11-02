package fr.kevindvz;

/**
 * Hello world!
 */
public final class App {
    private App() {

    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Jeu partie = new Jeu();
        partie.viderEcran();
        System.out.println("Bienvenue dans le jeu du pendu.");

        // Initialisation du jeux

        partie.invitCreationJoueurs();
        partie.initMotMasque();
        partie.viderEcran();

        // DEBUT DE PARTIE

        partie.afficherDessinPendu();
        partie.afficherMotMasque();
        partie.invitEssai();
        partie.nbreEssais++;

        while (partie.victoire = false || partie.essaisRestants > 1) {
            partie.viderEcran();
            partie.analyserLettreRefreshAffichage();
            partie.resoudreVictoire();
            partie.afficherDessinPendu();
            partie.afficherMotMasque();
            partie.invitEssai();
            partie.nbreEssais++;
        }
        // FIN de partie
        partie.afficherMessageFinPartie();

    }
}
