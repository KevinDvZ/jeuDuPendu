package fr.kevindvz;

public class Joueur {
    String nom;
    int pointsPartie;
    int pointsCumules;
    int nombredeVictoires;

    public Joueur(String nom) {
        this.nom = nom;
        this.pointsPartie = 0;
        this.pointsCumules = 0;
        this.nombredeVictoires = 0;
    }

    public int getPoints() {
        return pointsCumules;
    }

    public void setPoints(int points) {
        this.pointsCumules = points;
    }

    public void ajouterPoints(int points) {
        this.pointsPartie += pointsPartie;
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

    public int getPointsPartie() {
        return pointsPartie;
    }

    public void setPointsPartie(int pointsPartie) {
        this.pointsPartie = 0;
    }

}
