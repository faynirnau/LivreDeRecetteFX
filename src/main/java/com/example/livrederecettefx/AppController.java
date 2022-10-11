package com.example.livrederecettefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    private final LinkedList<Recette> recettes = AppLivreDeRecette.getRecetteLinkedList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private TextArea etapes;

    @FXML
    private URL location;
    @FXML
    private Button ajouterRecette;
    @FXML
    private Button ajouterIngredient;

    @FXML
    public ListView<String> listIngredient;
    @FXML
    public ListView<String> recetteListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Recette i:recettes) {
            recetteListView.getItems().add(i.getNomRecette());
        }
    }
    @FXML
    void ajouterIngredient(ActionEvent event) {}

    @FXML
    void ajouterRecette(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoaderAjouterRecette = new FXMLLoader(AppLivreDeRecette.class.getResource("recetteAjouterRecette.fxml"));
        Scene sceneAjouterRecette = new Scene(fxmlLoaderAjouterRecette.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Ajouter une recettes !!");
        stage.setScene(sceneAjouterRecette);
        stage.show();
    }

    @FXML
    void afficherIngredient(MouseEvent event) {
        int index = recetteListView.getSelectionModel().getSelectedIndex();
        listIngredient.getItems().clear();
        for (Aliment i:recettes.get(index).getAliments()) {
            String chaine = i.getNom() +' '+ i.getQuantite() + i.getUnit();
            listIngredient.getItems().add(chaine);
        }
        ajouterIngredient.setVisible(true);
        afficherEtapes();
    }
    @FXML
    void afficherEtapes(){
        etapes.clear();
        int index = recetteListView.getSelectionModel().getSelectedIndex();
        Recette recette = recettes.get(index);
        String etape = "";
        for(int i = 1;i<recette.getEtapes().size();i++) {
            etape = etape + "Etape : " + i + "\n";
            etape += recette.getEtapes().get(i);
            etape += "\n";
            etape += "\n";
        }
        etapes.setText(etape);
    }

}
