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
        while (partie.ecranChoixJoueur() == false) {
            System.out.println("mdr");
        }

    }
}
