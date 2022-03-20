package com.example.project;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CalendarController extends Controller implements Initializable {
    @FXML
    public TableView<CalendarMedicament> calendarview;

    @FXML
    public TableColumn<CalendarMedicament, String> drug;

    @FXML
    public TableColumn<CalendarMedicament, String> numberPill;

    @FXML
    public TableColumn<CalendarMedicament, String> dosePill;

    @FXML
    public TableColumn<CalendarMedicament, String> hour;

    @FXML
    public TableColumn<CalendarMedicament, Boolean> done;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<CalendarMedicament> pill = null; // receive list of product from database
        try {
            pill = Database.getInstance().receiveDataCalendar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        drug.setCellValueFactory(new PropertyValueFactory<>("drug")); // set id of product in tableView
        numberPill.setCellValueFactory(new PropertyValueFactory<>("NumberPill")); // set id of product in tableView
        dosePill.setCellValueFactory(new PropertyValueFactory<>("dosePill")); // set name of product in tableView
        hour.setCellValueFactory(new PropertyValueFactory<>("Hour")); // set cost of product in tableView
        done.setCellValueFactory(new PropertyValueFactory<>("Done")); // set cost of product in tableView

        calendarview.setItems(pill); // set list of product in tableView
    }

    public void produceTextFile(ActionEvent actionEvent) {
    }
}
