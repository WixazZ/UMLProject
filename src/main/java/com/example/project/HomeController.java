package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class HomeController extends Controller {

    @FXML
    public void onChangePageLogin(ActionEvent event) throws IOException {
        if (Database.isSuccess()){
            changeScreen(event, "login-page.fxml");
        } else {
            Controller.showAlert(Alert.AlertType.ERROR, "Error", "Error connecting to the database. Please try again later or contact the administrator."); // Show error message
        }
    }

    @FXML
    public void onChangePageSignUp(ActionEvent event) throws IOException {
        if (Database.isSuccess()){
            changeScreen(event, "information-page.fxml");
        } else {
            Controller.showAlert(Alert.AlertType.ERROR, "Error", "Error connecting to the database. Please try again later or contact the administrator."); // Show error message
        }
    }

}
