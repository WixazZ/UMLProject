package com.example.project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorController extends Controller implements Initializable {
    @FXML
    public Label nameDoctorPage;

    @FXML
    public Label specialityDoctorPage;

    @FXML
    public Label adressDoctorPage;

    @FXML
    public Label phoneDoctorPage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //TODO: fill data
        /*nameDoctorPage.setText();
        specialityDoctorPage.setText(speciality);
        adressDoctorPage.setText(adress);
        phoneDoctorPage.setText(phone);*/
    }


}
