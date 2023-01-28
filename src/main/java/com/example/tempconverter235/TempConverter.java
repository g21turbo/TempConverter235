package com.example.tempconverter235;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class TempConverter extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Image image = new Image("/Images/thermoicon.jpeg");
       // ImageView imageView = new ImageView(image);
        FXMLLoader fxmlLoader = new FXMLLoader(TempConverter.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 333);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}