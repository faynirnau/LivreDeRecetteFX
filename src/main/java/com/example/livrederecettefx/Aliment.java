package com.example.livrederecettefx;

public class Aliment {
    private final String nom;
    private final double quantite;
    private final char unit;

    public Aliment(String nom, double quantite, char unit) {
        this.nom = nom;
        this.quantite = quantite;
        this.unit = unit;
    }

    public String getNom() {
        return nom;
    }

    public double getQuantite() {
        return quantite;
    }

    public char getUnit() {
        return unit;
    }
    public void afficheAliment(){
        System.out.println(
                this.getNom() +
                " " +
                this.getQuantite() +
                " " +
                this.getUnit()
        );
    }
}
