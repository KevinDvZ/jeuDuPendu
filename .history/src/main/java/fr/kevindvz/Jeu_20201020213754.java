package fr.kevindvz;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;

    public String jeu() {
        faker = new Faker(new Locale("fr"));
        String test = faker.name().firstName();
        System.out.println(test);
        return test;

    }

}
