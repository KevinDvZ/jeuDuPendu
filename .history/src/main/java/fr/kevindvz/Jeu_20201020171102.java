package fr.kevindvz;

import com.github.javafaker.Faker;

public class Jeu {

    Faker faker = new faker();

    jeu(){
    String name = faker.name().fullName(); // Miss Samanta Schmidt
String firstName = faker.name().firstName(); // Emory
String lastName = faker.name().lastName(); // Barton

        console.log(name);
    }

}
