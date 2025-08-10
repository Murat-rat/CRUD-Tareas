package com.example.crud_tareas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TareasApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TareasApplication.class.getResource("tareas-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570, 550);
        stage.setTitle("Lista de Tareas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}