package com.example.project;

public record CalendarMedicament(String drug, int numberPill, String dosePill, String hour, Boolean done){

    // getter
    public String getDrug(){
        return drug;
    }
    public int getNumberPill(){
        return numberPill;
    }
    public String getDosePill(){
        return dosePill;
    }
    public String getHour(){
        return hour;
    }
    public Boolean getDone(){
        return done;
    }

}
