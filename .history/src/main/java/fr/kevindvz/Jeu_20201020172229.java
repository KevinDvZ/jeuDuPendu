package fr.kevindvz;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker;

    public Faker Jeu(Faker faker) {
        faker = new Faker();
        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

    }

}
