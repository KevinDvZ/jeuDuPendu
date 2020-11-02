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
        while (partie.ecranChoixJoueur() == false) {
            System.out.println("");
        }
        partie.ecranCreationJoueurs();
        partie.viderEcran();
        partie.afficherDessinPendu();
        partie.invitationCommande();

    }
}
