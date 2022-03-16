package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmergencyController extends Controller implements Initializable {
    @FXML
    public Label lastNameEmergency;

    @FXML
    public Label firstNameEmergency;

    @FXML
    public Label dateBirthEmergency;

    @FXML
    public Label emailEmergency;

    @FXML
    public Label phoneNumberEmergency;

    @FXML
    public Label emergencyPhoneEmergency;

    @FXML
    public Label herPhoneEmergency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //TODO: fill data
        /*lastNameEmergency.setText();
        firstNameEmergency.setText();
        dateBirthEmergency.setText();
        emailEmergency.setText();
        phoneNumberEmergency.setText();
        emergencyPhoneEmergency.setText();
        herPhoneEmergency.setText();*/
    }
}
