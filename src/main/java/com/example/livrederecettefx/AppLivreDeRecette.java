package com.example.livrederecettefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class AppLivreDeRecette extends Application {
    static AppController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppLivreDeRecette.class.getResource("recette-view.fxml"));
        controller = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Livre de recette");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}