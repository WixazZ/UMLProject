package com.example.project;

public final class MedicationClass {

    private final String StartDate;
    private final String EndDate;
    private final String Name;
    private final String Dosage;
    private final String Hour;

    public MedicationClass(String StartDate, String EndDate, String Name, String Dosage, String Hour) {

        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Name = Name;
        this.Dosage = Dosage;
        this.Hour = Hour;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }


    public String getName() {
        return Name;
    }

    public String getDosage() {
        return Dosage;
    }

    public String getHour() {
        return Hour;
    }
}