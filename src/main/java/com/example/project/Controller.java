package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    protected void changeScreen(ActionEvent event, String page) throws IOException { // change to home scene
        FXMLLoader fmxHome = new FXMLLoader(Application.class.getResource(page)); // load home scene
        Scene sceneHome = new Scene(fmxHome.load()); // create scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // get stage
        stage.setScene(sceneHome); // set scene
        stage.show(); // show scene
    }

    /**
     * This method is called when the user add data / remove data from the database,
     * if there is an error in the database or if the user not respect the format of data.
     * @param alertType the type of alert
     * @param title the title of the alert
     * @param message  the message of the alert
     */
    public static void showAlert(Alert.AlertType alertType, String title, String message) { // show alert
        Alert alert = new Alert(alertType); // create alert
        alert.setTitle(title); // set title
        alert.setHeaderText(null); // set header
        alert.setContentText(message); // set content
        alert.showAndWait().ifPresent(response -> {}); // show alert and wait for response
    }
}