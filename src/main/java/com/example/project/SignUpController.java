package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SignUpController extends Controller {


    public void changeScreenMenu(ActionEvent event) throws IOException {
        changeScreen(event, "menu-page.fxml");
    }
}
