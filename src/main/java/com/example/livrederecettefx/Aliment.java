package com.example.livrederecettefx;

import java.io.Serializable;

public class Aliment implements Serializable {
    private String nom;
    private double quantite;
    private char unit;

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
