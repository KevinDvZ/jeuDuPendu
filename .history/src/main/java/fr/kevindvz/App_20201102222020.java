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

        // Creation instance jeu
        Jeu partie = new Jeu();
        partie.viderEcran();
        System.out.println("Bienvenue dans le jeu du pendu.");
        Boolean stop = false;

        // Initialisation du jeux

        partie.invitCreationJoueurs();
        partie.initMotMasque();

        // DEBUT DE PARTIE
        while (stop == false) {

            do {
                partie.afficherDessinPendu();
                partie.afficherMotMasque();
                partie.invitEssai();
                partie.nbreEssais++;
                partie.viderEcran();
                partie.analyserLettreRefreshAffichage();
                partie.resoudreVictoire();
                if (partie.essaisRestants == 0) {
                    break;
                }

            } while (partie.victoire == false);
            partie.afficherMessageFinPartie();
            stop = partie.invitNouvellePartie();

        }
    }
}
