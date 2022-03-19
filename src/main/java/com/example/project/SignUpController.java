package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController extends Controller {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField rePassword;

    @FXML
    private void onClickSignUp(ActionEvent event) throws Exception {
        // check if regex username is correct
        if (!username.getText().matches("^[a-zA-Z0-9]*$")) {
            username.setText("");
            username.setPromptText("Username must be alphanumeric");
        }
        // check if password and re-password are the same
        if (!password.getText().equals(rePassword.getText())) {
            password.setText("");
            rePassword.setText("");
            password.setPromptText("Password and re-password must be the same");
            rePassword.setPromptText("Password and re-password must be the same");
        }
        // check if password is at least 8 characters long
        if (password.getText().length() < 8) {
            password.setText("");
            rePassword.setText("");
            password.setPromptText("Password must be at least 8 characters long");
            rePassword.setPromptText("Password must be at least 8 characters long");
        }
        // check if username is not already taken
        if (Database.getInstance().getUser(username.getText()) && username.getText().equals("")) {
            username.setText("");
            username.setPromptText("Username is already taken");
        } else {
            // if all checks are passed, create new user
            Database.getInstance().createUser(username.getText(), password.getText());
            changeScreenMenu(event);
        }

    }

    public void changeScreenMenu(ActionEvent event) throws IOException {
        changeScreen(event, "menu-page.fxml");
    }
}
