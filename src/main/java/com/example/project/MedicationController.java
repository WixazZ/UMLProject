package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicationController extends Controller implements Initializable {
    @FXML
    public TableView<User> medicationview;

    @FXML
    public TableColumn<MedicationClass, String> StartDate;

    @FXML
    public TableColumn<MedicationClass, String> EndDate;

    @FXML
    public TableColumn<MedicationClass, String> Sickness;

    @FXML
    public TableColumn<MedicationClass, String> Medication;

    @FXML
    public TableColumn<MedicationClass, String> Dosage;

    @FXML
    public TableColumn<MedicationClass, String> Hour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
