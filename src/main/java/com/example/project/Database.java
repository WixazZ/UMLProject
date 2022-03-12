package com.example.project;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    private Database() {
        try {
            String url = "jdbc:mysql://localhost/umlproject"; // URL for the database
            con = DriverManager.getConnection(url,"root", "alexpara"); // Connection object PASSWORD and USERNAME to be modified
            stmt = con.createStatement(); // Statement object
            setSuccess(true); // Set success to true
        } catch (SQLException e) { // If the connection is not successful
            e.printStackTrace(); // Print the error
            setSuccess(false); // Set success to false
            Controller.showAlert(Alert.AlertType.ERROR, "Error", "Error connecting to the database. Please try again later or contact the administrator."); // Show error message
        }
    }

    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        return instance;
    }

    public void setSuccess(boolean success) {
        Database.success = success;
    }
    public static boolean isSuccess() {
        return success;
    }
}
