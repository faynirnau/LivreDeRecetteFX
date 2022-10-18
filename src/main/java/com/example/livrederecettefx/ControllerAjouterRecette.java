package com.example.livrederecettefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ControllerAjouterRecette {

    private ArrayList<Aliment> aliments = new ArrayList<>();
    private HashMap<Integer,String> etapes = new HashMap<Integer, String>();

    @FXML
    private Button annuler;
    @FXML
    private Button valider;
    @FXML
    private Button ajouterIngredient;
    @FXML
    private Button creerEtape;

    @FXML
    private ListView<String> ingredients;

    @FXML
    private TextField nomIngredientFX;

    @FXML
    private TextField nomRecetteFX;

    @FXML
    private TextField quantiteFX;

    @FXML
    private TextField tempsRecetteFX;

    @FXML
    private TextField uniteFX;
    @FXML
    private TextArea etapeFX;

    @FXML
    void annuler(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoaderAjouterRecette = new FXMLLoader(AppLivreDeRecette.class.getResource("recette-view.fxml"));
        Scene sceneAjouterRecette = new Scene(fxmlLoaderAjouterRecette.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Livre de recette");
        stage.setScene(sceneAjouterRecette);
        stage.show();
    }
    @FXML
    void valider(ActionEvent event) throws IOException {
        int temps = Integer.parseInt(tempsRecetteFX.getText());
        String nomRecette = nomRecetteFX.getText();
        Recette recette = new Recette(nomRecette,aliments,etapes,temps);
        AppLivreDeRecette.getRecetteLinkedList().add(recette);
        AppLivreDeRecette.sauvegarde(AppLivreDeRecette.getRecetteLinkedList());
        annuler(event);
    }
    @FXML
    void AjouterIngredient(ActionEvent event) {
        Aliment aliment = new Aliment(nomIngredientFX.getText(), Double.parseDouble(quantiteFX.getText()), uniteFX.getCharacters().charAt(0));
        aliments.add(aliment);
        String chaine = aliment.getNom() +' '+ aliment.getQuantite() + aliment.getUnit();
        ingredients.getItems().add(chaine);
        nomIngredientFX.clear();
        quantiteFX.clear();
        uniteFX.clear();
    }
    @FXML
    void ajouterEtape(ActionEvent event) {
        etapes.put(etapes.size()+1,etapeFX.getText());
        System.out.println("add"+etapeFX.getText());
        etapeFX.clear();
    }
}
