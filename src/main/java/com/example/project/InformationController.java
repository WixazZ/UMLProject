package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class InformationController extends Controller {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField birthday;

    @FXML
    private TextField phoneNumber;

    @FXML
    public void onClickContinue(ActionEvent event) throws IOException {
        // check if regex firstName is correct
        if (!firstName.getText().matches("[a-zA-Z]+")) {
            firstName.setText("");
            firstName.setPromptText("Invalid first name");
        } else {
            firstName.setPromptText("First name");
        }

        // check if regex lastName is correct
        if (!lastName.getText().matches("[a-zA-Z]+")) {
            lastName.setText("");
            lastName.setPromptText("Invalid last name");
        } else {
            lastName.setPromptText("Last name");
        }

        // check if regex birthday is correct
        if (!birthday.getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            birthday.setText("");
            birthday.setPromptText("Invalid birthday : dd/mm/yyyy");
        } else {
            birthday.setPromptText("Birthday");
        }

        // check if regex phoneNumber is correct
        if (!phoneNumber.getText().matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
            phoneNumber.setText("");
            phoneNumber.setPromptText("Invalid : xxx-xxx-xxxx");
        } else {
            phoneNumber.setPromptText("Phone number");
        }

        // check if all fields are correct
        if (firstName.getText().matches("[a-zA-Z]+") && lastName.getText().matches("[a-zA-Z]+") && birthday.getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}") && phoneNumber.getText().matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
            User.getInstance().setFirstName(firstName.getText());
            User.getInstance().setLastName(lastName.getText());
            User.getInstance().setBirthday(birthday.getText());
            User.getInstance().setPhone(phoneNumber.getText());
            onChangePageSignUp(event);
        }
    }

    public void onChangePageSignUp(ActionEvent event) throws IOException {
        changeScreen(event, "signup-page.fxml");
    }
}
