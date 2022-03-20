package com.example.project;

import javafx.application.Application;
import javafx.stage.Stage;

public class MedicationClass {

    private String StartDate;
    private String EndDate;
    private String Sikness;
    private String MedicationName;
    private String Dosage;
    private String Hour;

    public MedicationClass(String StartDate, String EndDate, String Sikness, String MedicationName, String Dosage, String Hour) {

        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Sikness = Sikness;
        this.MedicationName = MedicationName;
        this.Dosage = Dosage;
        this.Hour = Hour;
    }


}
