package fr.kevindvz;

import com.github.javafaker.Faker;

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
        Jeu test = new Jeu();
        test.jeu();

        System.out.println(test);
    }
}
