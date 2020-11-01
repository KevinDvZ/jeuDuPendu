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
        partie.ecranChoixJoueur();
        while (partie.ecranChoixJoueur() == false) {
            partie.ecranChoixJoueur();
        }

    }
}
