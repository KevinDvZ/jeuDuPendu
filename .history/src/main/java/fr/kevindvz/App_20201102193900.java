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
        partie.invitNombreJoueurs();
        partie.invitCreationJoueurs();
        partie.initMotMasque();
        partie.viderEcran();

        // DEBUT DE PARTIE

        partie.afficherDessinPendu();
        partie.afficherMotMasque();
        partie.invitEssai();
        while (!partie.victoire || partie.essaisRestants == 0) {
            partie.viderEcran();
            partie.analyserLettreRefreshAffichage();
            partie.afficherDessinPendu();
            partie.afficherMotMasque();
            partie.invitEssai();

        }

    }
}
