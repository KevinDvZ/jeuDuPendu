package fr.kevindvz;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class Jeu {

    String motMystere;

    public void jeu() {
        int hasard = new Random().nextInt(6);
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
            case 3:
                motMystere = new Faker(new Locale("fr")).color().name();
                break;
            case 4:
                motMystere = new Faker(new Locale("fr")).book().title();
                break;
            case 5:
                motMystere = new Faker(new Locale("fr")).job().title();
            default:
                break;
        }

        // String motMystere = faker.name().firstName();
        // String motMystere = faker.address().city();
        // String motMystere = faker.animal().name();
        // String motMystere = faker.color().name();
        // String motMystere = faker.demographic().sex();

        System.out.println(motMystere);

    }

}
