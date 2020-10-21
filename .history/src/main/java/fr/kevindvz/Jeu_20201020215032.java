package fr.kevindvz;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;

    public void jeu() {
        faker = new Faker(new Locale("fr"));
        String motMystere = faker.name().firstName();
        System.out.println(motMystere);

    }

}
