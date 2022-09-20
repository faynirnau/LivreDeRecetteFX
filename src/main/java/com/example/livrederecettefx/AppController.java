package com.example.livrederecettefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> recetteListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Livre livreDeRecette = new Livre();
        livreDeRecette.major();
        ArrayList<String> listNomRecette = new ArrayList<>();
        for (int i = 0; i < livreDeRecette.getRecetteLinkedList().size(); i++){
            listNomRecette.add(livreDeRecette.getRecetteLinkedList().get(i).getNomRecette());
        }

        ObservableList<String> recetteObservableList = FXCollections.observableList(listNomRecette); //donner liste des noms de recette
        recetteListView.setItems(recetteObservableList); //donner ObservableList des noms de recette
    }
}