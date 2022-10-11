package com.example.livrederecettefx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Recette implements Serializable {
    private String nomRecette;
    private ArrayList<Aliment> aliments;
    private HashMap<Integer,String> etapes;
    private int temps;

    public Recette(String nomRecette, ArrayList<Aliment> aliments, HashMap<Integer,String> etapes, int temps) {
        this.setNomRecette(nomRecette);
        this.setAliments((ArrayList<Aliment>) aliments.clone());
        this.setEtapes((HashMap<Integer, String>) etapes.clone());
        this.setTemps(temps);
    }

    public void setAliments(ArrayList<Aliment> aliments) {
        this.aliments = aliments;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public void setEtapes(HashMap<Integer, String> etapes) {
        this.etapes = etapes;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public ArrayList<Aliment> getAliments() {
        return aliments;
    }

    public HashMap<Integer,String> getEtapes() {
        return etapes;
    }

    public int getTemps() {
        return temps;
    }



    public void afficherRecette(){
        System.out.println(this.getNomRecette());
        System.out.println("Le temps de cuisine est estimé à : " + this.getTemps() + "min");
        System.out.println(" ");
        System.out.println("Voici la liste des ingrédients :");
        for (int i = 0; i < this.getAliments().size();i++){
            this.getAliments().get(i).afficheAliment();
        }
        System.out.println(" ");
        for (int i = 1; i < this.getEtapes().size();i++){
            System.out.println("Étape "+ i);
            System.out.println(this.getEtapes().get(i));
            System.out.println(" ");
        }
    }

}
