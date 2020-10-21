package fr.kevindvz;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;

    public void jeu() {
        int hasard = new Random().nextInt(4);
        switch (hasard) {
            case 0: // nom
                String motMystere = faker.name().firstName();
                break;
            case 1: // ville
                String motMystere = faker.address().city();
                break;
            case 2: // animal
                String motMystere = faker.animal().name();
                break;
            case 3:

            default:
                break;
        }
        faker = new Faker(new Locale("fr"));
        // String motMystere = faker.name().firstName();
        // String motMystere = faker.address().city();
        // String motMystere = faker.animal().name();
        // String motMystere = faker.color().name();
        // String motMystere = faker.demographic().sex();
        String motMystere = faker.food().fruit();

        System.out.println(motMystere);

    }

}
