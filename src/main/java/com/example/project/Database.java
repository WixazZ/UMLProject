package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;

import java.sql.*;

public final class Database {

    private static Database instance;
    /**
     * Connection object to the database.
     */
    public Connection con = null; // Connection object

    /**
     * Statement object to the database.
     */
    private Statement stmt = null; // Statement object

    /**
     * Boolean to check if the connection was successful
     */
    private static boolean success; // Boolean to check if the connection was successful

    private Database() throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"; // URL for the database
            con = DriverManager.getConnection(url,"root", "alexpara"); // Connection object PASSWORD and USERNAME to be modified
            stmt = con.createStatement(); // Statement object
            stmt.executeUpdate("USE UMLProject"); // Execute the query
            setSuccess(true); // Set success to true
        } catch (SQLException e) { // If the connection is not successful
            e.printStackTrace(); // Print the error
            setSuccess(false); // Set success to false
            Controller.showAlert(Alert.AlertType.ERROR, "Error", "Error connecting to the database. Please try again later or contact the administrator."); // Show error message
        }
    }

    public static Database getInstance() throws Exception {
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void setSuccess(boolean success) {
        Database.success = success;
    }
    public static boolean isSuccess() {
        return success;
    }

    public boolean getUser(String username) {
        try {
            String query = "SELECT * FROM Users WHERE username = '" + username + "'"; // Query to check if the user exists
            stmt.executeQuery(query); // Execute the query
            return true; // Return true
        } catch (SQLException e) { // If the connection is not successful
            e.printStackTrace(); // Print the error
            return false; // Return false
        }
    }

    public boolean getElder(String username, String password) {
        try {
            String query = "SELECT Id_Elder FROM Users WHERE username = '" + username + "' AND password = '" + password + "'"; // Query to check if the user exists
            ResultSet res = stmt.executeQuery(query); // Execute the query
            if (res.next()) { // If the result is not empty
                String queryElder = "SELECT * FROM Elder WHERE Id_Elder = " + res.getInt("Id_Elder"); // Query to get the elder
                ResultSet resElder = stmt.executeQuery(queryElder); // Execute the query
                if (resElder.next()) { // If the result is not empty
                    User.getInstance().setId(resElder.getString("Id_Elder")); // Set the id
                    User.getInstance().setFirstName(resElder.getString("Firstname")); // Set the Firstname
                    User.getInstance().setLastName(resElder.getString("Lastname")); // Set the Lastname
                    User.getInstance().setPhone(resElder.getString("Phone")); // Set the Phone
                    return true; // Return true
                }

                return false; // Return
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return
        }
        return false;
    }


    public ObservableList<HealthRecord> receiveDataHealthRecord(){
        ObservableList<HealthRecord> healthRecords = FXCollections.observableArrayList();
        try {
            String query = "SELECT Id_Illnesses FROM Had where ID_Elder = '" + User.getInstance().getId() + "'";
            ResultSet res = stmt.executeQuery(query);
            Statement stmt2 = con.createStatement(); // Statement object
            while (res.next()) {
                String queryIllness = "SELECT Name, Details FROM Illnesses WHERE Id_Illnesses = '" + res.getInt("Id_Illnesses") + "'";
                ResultSet resIllness = stmt2.executeQuery(queryIllness);
                if (resIllness.next()) {
                    healthRecords.add(new HealthRecord(resIllness.getString("Name"), resIllness.getString("Details")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthRecords;
    }




    public ObservableList<MedicationClass> receiveDataPrescriptionThread(){
        ObservableList<MedicationClass> prescriptions = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Prescription where Id_Elder = '" + User.getInstance().getId() + "' and  DATE_FORMAT(DosingTimes,'%k:%i') = DATE_FORMAT(curtime(),'%k:%i')";
            ResultSet res = stmt.executeQuery(query);
            Statement stmt2 = con.createStatement(); // Statement object
            while (res.next()) {
                String queryMedication = "SELECT Name FROM Medicament WHERE Id_Medicament = '" + res.getInt("Id_Medicament") + "'";
                ResultSet resMedication = stmt2.executeQuery(queryMedication);

                if (resMedication.next()) { // If the result is not empty
                    prescriptions.add(new MedicationClass(res.getString("FirstDate"), res.getString("LastDate"), resMedication.getString("Name"), res.getString("Dosages"), res.getString("DosingTimes")));

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }

    public ObservableList<MedicationClass> receiveDataPrescription(){
        ObservableList<MedicationClass> prescriptions = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Prescription where Id_Elder = '" + User.getInstance().getId() + "'";
            ResultSet res = stmt.executeQuery(query);
            Statement stmt2 = con.createStatement(); // Statement object
            while (res.next()) {
                String queryMedication = "SELECT Name FROM Medicament WHERE Id_Medicament = '" + res.getInt("Id_Medicament") + "'";
                ResultSet resMedication = stmt2.executeQuery(queryMedication);

                if (resMedication.next()) { // If the result is not empty
                    prescriptions.add(new MedicationClass(res.getString("FirstDate"), res.getString("LastDate"), resMedication.getString("Name"), res.getString("Dosages"), res.getString("DosingTimes")));

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }

    public ObservableList<CalendarMedicament> receiveDataCalendar(){
        ObservableList<CalendarMedicament> data = FXCollections.observableArrayList(); // ObservableList object to store the data
        try {
            String query = "SELECT * FROM Prescription where Id_Elder = '"+ User.getInstance().getId()+"'"; // Query to get the calendar
            ResultSet res = stmt.executeQuery(query); // Execute the query
            Statement stmt2 = con.createStatement(); // Statement object
            int i = 0;
            while (res.next()) { // If the result is not empty
                String queryMedicament = "SELECT Name FROM Medicament where Id_Medicament = '"+ res.getInt("Id_Medicament")+"'"; // Query to get the calendar
                ResultSet resMedicament = stmt2.executeQuery(queryMedicament); // Execute the query
                if (resMedicament.next()) { // If the result is not empty
                    data.add(new CalendarMedicament(resMedicament.getString("Name"), 1, res.getString("Dosages"), res.getString("DosingTimes"), new CheckBox())); // Add the data to the ObservableList object
                    i++;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void createUser(String username, String password){

        String day = User.getInstance().getBirthday().substring(0, 2); // Get the year
        String month = User.getInstance().getBirthday().substring(3, 5); // Get the year
        String year = User.getInstance().getBirthday().substring(6, 10); // Get the year
        String birthday = year + "-" + month + "-" + day; // Set the birthdate

        // create user with data of User class
        try {
            String queryElder = "insert into Elder (Firstname, Lastname, Phone, Birthday) values('"+User.getInstance().getFirstName()+"', '"+User.getInstance().getLastName()+"','"+User.getInstance().getPhone()+"', '"+birthday+"')";
            String queryID = "SELECT Id_Elder FROM Elder WHERE Phone = '"+User.getInstance().getPhone()+"'"; // Query to check if the user exists

            stmt.executeUpdate(queryElder);

            ResultSet res = stmt.executeQuery(queryID); // Execute the query
            if(res.next()){
                String id_Elder = res.getString("Id_Elder");
                String queryUsers = "insert into Users (Username, Password, id_Elder) values('"+username+"', '"+password+"', + '"+ id_Elder +"')"; // Query to check if the user exists
                User.getInstance().setId(id_Elder);
                stmt.executeUpdate(queryUsers);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            con.close(); // Close the connection
        } catch (SQLException e) { // If the connection is not successful
            e.printStackTrace(); // Print the error
        }
    }
}
