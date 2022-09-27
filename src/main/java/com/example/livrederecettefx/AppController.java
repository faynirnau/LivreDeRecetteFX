package com.example.livrederecettefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    private Livre livreDeRecette = new Livre();

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
        this.livreDeRecette.major();
        for (Recette i:this.livreDeRecette.getRecetteLinkedList()) {
            this.recetteListView.getItems().add(i.getNomRecette());
        }
    }
    @FXML
    void ajouterIngredient(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    void ajouterRecette(ActionEvent event) {
        System.out.println("hello");
    }

    @FXML
    void afficherIngredient(MouseEvent event) {
        int index = this.recetteListView.getSelectionModel().getSelectedIndex();
        System.out.println(index);
        this.listIngredient.getItems().clear();
        for (Aliment i:livreDeRecette.getRecetteLinkedList().get(index).getAliments()) {
            this.listIngredient.getItems().add(i.getNom());
        }
        afficherEtapes();
    }
    @FXML
    void afficherEtapes(){
        this.etapes.clear();
        int index = this.recetteListView.getSelectionModel().getSelectedIndex();
        Recette recette = this.livreDeRecette.getRecetteLinkedList().get(index);
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
