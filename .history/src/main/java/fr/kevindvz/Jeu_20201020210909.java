package fr.kevindvz;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;

    public Faker jeu() {
        faker = new Faker(new Locale("fr-FR"));
        return faker;

    }

}
