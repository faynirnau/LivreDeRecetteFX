package com.example.livrederecettefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class AppLivreDeRecette extends Application {
    private static LinkedList<Recette> recetteLinkedList;


    public static LinkedList<Recette> getRecetteLinkedList() {
        return recetteLinkedList;
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppLivreDeRecette.class.getResource("recette-view.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load());
        stage.setTitle("Livre de recette");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args){
        recetteLinkedList = charger("livre.dat");
        launch();
    }

    public static void major(){
        ArrayList<Aliment> aliments;
        aliments = creerIngredientPateCarbonara();
        recetteLinkedList = new LinkedList<>();

        HashMap<Integer, String> etapes;
        etapes = creerEtapePateCarbonara();


        Recette pateCarbonara = new Recette("Pâte à la carbonara", aliments, etapes,20);
        recetteLinkedList.add(pateCarbonara);
        aliments.clear();
        etapes.clear();
        Recette roseDesSables = new Recette("Rose des sables", aliments, etapes, 10);
        recetteLinkedList.add(roseDesSables);
    }


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
    public static void sauvegarde(LinkedList<Recette> objet){
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("livre.dat");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(objet);
            oos.flush();
        }
        catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static LinkedList<Recette> charger(String nomFichier) {
        ObjectInputStream ois = null;
        LinkedList<Recette> recettes;
        try {
            final FileInputStream fichier = new FileInputStream(nomFichier);
            ois = new ObjectInputStream(fichier);
            recettes = (LinkedList<Recette>) ois.readObject();
        } catch (final Exception e) {
            major();
            sauvegarde(recetteLinkedList);
            recettes = recetteLinkedList;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return recettes;
    }

}