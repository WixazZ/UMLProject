package com.example.project;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class NotifManager implements Runnable {
    private int userID;
    boolean running = false;


    @Override
    public void run() {
        this.running = true;
        while(running){
            synchronized (this) {
                try {
                    checkNotif();
                    System.out.println("NotifManager: waiting");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wait(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void stop(){
        this.running = false;
    }

    private void checkNotif() {

        ObservableList<MedicationClass> meds = null;
        try {
            meds = Database.getInstance().receiveDataPrescriptionThread();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert meds != null;
        for (MedicationClass med : meds) {
            System.out.println("Do not forget to take your "+ med.getName()+" at "+ med.getHour()+" !");
            //Controller.showAlert(Alert.AlertType.WARNING, "Reminder", ); // Show error message
        }
    }
}