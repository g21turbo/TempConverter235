package com.example.tempconverter235;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;


public class TempConverterController {

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem helpMenuItem;

    private ObservableList<String> tempUnits;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private TextArea resultArea;

    @FXML
    private TextField inputValueField;


    @FXML
    private Button convert;


    @FXML
    private void showHelp() {
        Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
        helpAlert.setTitle("Help");
        helpAlert.setHeaderText("Help Information");
        helpAlert.setContentText("This is the help information\n" +
                "1. Select a unit to convert.\n" +
                "2. Enter a value.\n" +
                "3. Select a unit to convert to.\n" +
                "4. Click 'Convert' - Results will be displayed to the right");
        helpAlert.show();
    }

    @FXML
    public void initialize() {
        tempUnits = FXCollections.observableArrayList("Fahrenheit", "Celsius", "Kelvin");
        comboBox1.setItems(tempUnits);
        comboBox1.setPromptText("Select a Unit to Convert");

        comboBox2.setItems(tempUnits);
        comboBox2.setPromptText("Select a Unit to Convert");

        closeMenuItem.setOnAction(event -> {
            Platform.exit();
        });
    }


    private double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    private double fahrenheitToKelvinTo(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 +273.15;
    }

    private double kelvinToCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    private double celsiusToKelvin(double celsius) {
        return (celsius + 273.15);
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    @FXML
    public void convert(javafx.event.ActionEvent actionEvent) {
        String inputUnit = comboBox1.getValue();
        String outputUnit = comboBox2.getValue();
        double inputValue = Double.parseDouble(inputValueField.getText());


        if(inputUnit.equals("Kelvin") && outputUnit.equals("Fahrenheit")) {
            double result = kelvinToFahrenheit(inputValue);
            resultArea.setText(String.valueOf(result));
        }
        if(inputUnit.equals("Fahrenheit") && outputUnit.equals("Kelvin")) {
            double result = fahrenheitToKelvinTo(inputValue);
            resultArea.setText(String.valueOf(result));
        }


        if(inputUnit.equals("Fahrenheit") && outputUnit.equals("Celsius")) {
            double result = fahrenheitToCelsius(inputValue);
            resultArea.setText(String.valueOf(result));
        }
        if(inputUnit.equals("Celsius") && outputUnit.equals("Fahrenheit")) {
            double result = celsiusToFahrenheit(inputValue);
            resultArea.setText(String.valueOf(result));
        }

        if(inputUnit.equals("Celsius") && outputUnit.equals("Kelvin")) {
            double result = celsiusToKelvin(inputValue);
            resultArea.setText(String.valueOf(result));
        }
        if(inputUnit.equals("Kelvin") && outputUnit.equals("Celsius")) {
            double result = kelvinToCelsius(inputValue);
            resultArea.setText(String.valueOf(result));
        }
    }
}