package fr.kevindvz;

public class Joueur {
    String nom;
    int points;
    int nombredeVictoires;

    public Joueur(String nom) {
        this.nom = nom;
        this.points = 0;
        this.nombredeVictoires = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void ajouterPoints(int points) {
        this.points += points;
    }

    public int getNombredeVictoires() {
        return nombredeVictoires;
    }

    public void setNombredeVictoires(int nombredeVictoires) {
        this.nombredeVictoires = nombredeVictoires;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
