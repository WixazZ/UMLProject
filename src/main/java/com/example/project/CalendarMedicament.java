package com.example.project;

import javafx.scene.control.CheckBox;

import java.util.Objects;

public final class CalendarMedicament {

    private final String drug;
    private final int numberPill;
    private final String dosePill;
    private final String hour;
    public final CheckBox done;
    public final String PrescriptionID;

    public CalendarMedicament(String PrescriptionID, String drug, int numberPill, String dosePill, String hour, CheckBox done) {
        this.drug = drug;
        this.numberPill = numberPill;
        this.dosePill = dosePill;
        this.hour = hour;
        this.done = done;
        this.PrescriptionID = PrescriptionID;
    }

    public String getDrug() {
        return drug;
    }

    public int getNumberPill() {
        return numberPill;
    }

    public String getDosePill() {
        return dosePill;
    }

    public String getHour() {
        return hour;
    }

    public CheckBox getDone() {
        return done;
    }

    public String drug() {
        return drug;
    }

    public int numberPill() {
        return numberPill;
    }

    public String dosePill() {
        return dosePill;
    }

    public String hour() {
        return hour;
    }

    public CheckBox done() {
        return done;
    }


    public String getPrescriptionID() {
        return PrescriptionID;
    }
}
