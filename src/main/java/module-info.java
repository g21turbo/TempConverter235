module com.example.tempconverter235 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tempconverter235 to javafx.fxml;
    exports com.example.tempconverter235;
}