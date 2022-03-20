package com.example.project;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HealthRecordController extends Controller implements Initializable {
    @FXML
    public TableView<HealthRecord> healthRecordView;

    @FXML
    public TableColumn<HealthRecord, String> tName;

    @FXML
    public TableColumn<HealthRecord, String> tDetails;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<HealthRecord> pill = null; // receive list of product from database
        try {
            pill = Database.getInstance().receiveDataHealthRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tName.setCellValueFactory(new PropertyValueFactory<>("Name")); // set id of product in tableView
        tDetails.setCellValueFactory(new PropertyValueFactory<>("Details")); // set id of product in tableView

        healthRecordView.setItems(pill); // set list of product in tableView
    }
}
