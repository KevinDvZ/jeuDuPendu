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
        partie.invitNombreJoueurs();
        partie.invitCreationJoueurs();
        partie.initMotMystere();
        while (!partie.victoire) {
            partie.viderEcran();
            partie.afficherDessinPendu();
            partie.afficherMotMystere();
            partie.invitEssai();
            partie.analyserLettreRefreshAffichage();
        }

    }
}
