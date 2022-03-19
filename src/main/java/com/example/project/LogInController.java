package com.example.project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController extends Controller {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private void onClickChangeMenu(ActionEvent event) throws Exception {
        // check if password respect conditions
        // check if regex username is correct
        if (!username.getText().matches("^[a-zA-Z0-9]*$")) {
            username.setText("");
            username.setPromptText("Username must be alphanumeric");
        }
        // check if password is at least 8 characters long
        if (password.getText().length() < 8) {
            password.setText("");
            password.setPromptText("Password must be at least 8 characters long");
        } else {
            if (Database.getInstance().getElder(username.getText(), password.getText())) {
                changeScreen(event, "menu-page.fxml");
            } else {
                Controller.showAlert(Alert.AlertType.ERROR, "Error", "Error bad combination of username/password."); // Show error message
            }
        }

    }

    @FXML
    private void onClickChangeSignUp(ActionEvent event) throws IOException {
        changeScreen(event, "signup-page.fxml");
    }
}
