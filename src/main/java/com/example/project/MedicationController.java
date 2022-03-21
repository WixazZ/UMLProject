package com.example.project;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicationController extends Controller implements Initializable {


    public ObservableList<MedicationClass> prescriptionList;

    @FXML
    public TableView<MedicationClass> medicationview;

    @FXML
    public TableColumn<MedicationClass, String> startDate;

    @FXML
    public TableColumn<MedicationClass, String> finalDate;


    @FXML
    public TableColumn<MedicationClass, String> medication;

    @FXML
    public TableColumn<MedicationClass, String> dose;

    @FXML
    public TableColumn<MedicationClass, String> hour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            prescriptionList = Database.getInstance().receiveDataPrescription();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startDate.setCellValueFactory(new PropertyValueFactory<>("StartDate")); // set id of product in tableView
        finalDate.setCellValueFactory(new PropertyValueFactory<>("EndDate")); // set id of product in tableView
        medication.setCellValueFactory(new PropertyValueFactory<>("Name")); // set name of product in tableView
        dose.setCellValueFactory(new PropertyValueFactory<>("Dosage")); // set cost of product in tableView
        hour.setCellValueFactory(new PropertyValueFactory<>("Hour")); // set cost of product in tableView

        medicationview.setItems(prescriptionList); // set list of product in tableView


    }
}
