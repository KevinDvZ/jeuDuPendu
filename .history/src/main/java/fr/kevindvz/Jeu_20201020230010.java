package fr.kevindvz;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;
    String motMystere;

    public void jeu() {
        int hasard = new Random().nextInt(4);
        switch (hasard) {
            case 0: // nom
                motMystere = faker.name().firstName();
                break;
            case 1: // ville
                motMystere = faker.address().city();
                break;
            case 2: // animal
                motMystere = faker.animal().name();
                break;
            case 3:
                motMystere = faker.color().name();
                break;
            case 4:
                String motMystere = faker.color().name();
                break;
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
