package com.example.livrederecettefx;

import java.util.ArrayList;
import java.util.HashMap;

public class Recette {
    private final String nomRecette;
    private final ArrayList<Aliment> aliments;
    private final HashMap<Integer,String> etapes;
    private final int temps;

    public Recette(String nomRecette, ArrayList<Aliment> aliments, HashMap<Integer,String> etapes, int temps) {
        this.nomRecette = nomRecette;
        this.aliments = (ArrayList<Aliment>) aliments.clone();
        this.etapes = (HashMap<Integer, String>) etapes.clone();
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
    public void afficherRecetteFX(){

    }

}
