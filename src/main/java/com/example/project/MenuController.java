package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController extends Controller {

    @FXML
    public void onChangeProfile(ActionEvent event) throws IOException {
        changeScreen(event, "emmergency-page.fxml");
    }

    @FXML
    public void onChangeCalendar(ActionEvent event) throws IOException {
        changeScreen(event, "calendar-page.fxml");
    }

    @FXML
    public void onChangeMedication(ActionEvent event) throws IOException {
        changeScreen(event, "medication-page.fxml");
    }

    @FXML
    public void onChangeDoctors(ActionEvent event) throws IOException {
        changeScreen(event, "doctor-page.fxml");
    }

    @FXML
    public void onChangeHealthRecord(ActionEvent event) throws IOException {
        changeScreen(event, "healthRecord-page.fxml");
    }

}