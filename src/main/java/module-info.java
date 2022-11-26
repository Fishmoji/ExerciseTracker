module com.example.exercisetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercisetracker to javafx.fxml;
    exports com.example.exercisetracker;
}