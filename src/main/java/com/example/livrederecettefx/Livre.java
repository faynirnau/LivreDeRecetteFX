package com.example.livrederecettefx;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Livre {
    private LinkedList<Recette> recetteLinkedList = new LinkedList<>();

    public LinkedList<Recette> getRecetteLinkedList() {
        return recetteLinkedList;
    }

    public void major(){

        ArrayList<Aliment> aliments;
        aliments = creerIngredientPateCarbonara();

        HashMap<Integer, String> etapes;
        etapes = creerEtapePateCarbonara();


        Recette pateCarbonara = new Recette("Pâte à la carbonara", aliments, etapes,20);
        recetteLinkedList.add(pateCarbonara);
        aliments.clear();
        etapes.clear();
        Recette roseDesSables = new Recette("Rose des sables", aliments, etapes, 10);
        recetteLinkedList.add(roseDesSables);
    }

    /*
    Initialisation pâte à la carbonara.
    */
    private static ArrayList<Aliment> creerIngredientPateCarbonara(){
        Aliment pate = new Aliment("Pâte", 83.5,'g');
        Aliment parmesan = new Aliment("Parmesan", 10,'g');
        Aliment oeuf = new Aliment("Oeuf",1,'u');
        Aliment lardon = new Aliment("Lardon",41.5,'g');
        Aliment oignon = new Aliment("Oignon",1,'g');
        Aliment sel = new Aliment("Sel",0.02,'g');
        Aliment poivre = new Aliment("Poivre",0.02,'g');
        ArrayList<Aliment> listIngredient = new ArrayList<>();
        listIngredient.add(pate);
        listIngredient.add(parmesan);
        listIngredient.add(oeuf);
        listIngredient.add(lardon);
        listIngredient.add(oignon);
        listIngredient.add(sel);
        listIngredient.add(poivre);
        return listIngredient;
    }
    private static HashMap<Integer,String> creerEtapePateCarbonara(){
        HashMap<Integer, String> listEtape = new HashMap<>();
        listEtape.put(
                1,
                "Faire cuire les pâtes dans une grande casserole d'eau salée, le temps indiqué sur le paquet."
        );
        listEtape.put(
                2,
                "Pendant ce temps, casser les oeufs dans un récipient, ajouter le parmesan râpé, et battre le tout; saler et poivrer."
        );
        listEtape.put(
                3,
                "Faire cuire les lardons."
        );
        listEtape.put(
                4,
                "Une fois les pâtes cuites, les égoutter, mais pas trop (toujours garder un peu d'eau pour les pâtes en sauce)."
        );
        listEtape.put(
                5,
                "Ajouter les lardons, avec leur jus de cuisson, porter à feu très doux et y ajouter la préparation (oeuf, parmesan) en remuant sans arrêt."
        );
        listEtape.put(
                6,
                "Eteindre le feu avant que la préparation devienne trop sèche !"
        );
        listEtape.put(
                7,
                "Servir chaud, avec un peu de parmesan râpé en plus."
        );
        return listEtape;
    }
}
