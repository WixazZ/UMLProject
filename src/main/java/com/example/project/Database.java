package com.example.project;

import javafx.scene.control.Alert;

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

    public void createUser(String username, String password){

        String day = User.getInstance().getBirthday().substring(0, 1); // Get the year
        String month = User.getInstance().getBirthday().substring(3, 4); // Get the year
        String year = User.getInstance().getBirthday().substring(6, 10); // Get the year
        String birthday = year + "-" + month + "-" + day; // Set the birthdate

        // create user with data of User class
        try {
            String queryElder = "insert into Elder (Firstname, Lastname, Phone, Birthday) values('"+User.getInstance().getFirstName()+"', '"+User.getInstance().getLastName()+"','"+User.getInstance().getPhone()+"', '"+birthday+"')";

            String queryID = "SELECT Id_Elder FROM Elder WHERE Phone = '"+User.getInstance().getPhone()+"'"; // Query to check if the user exists

            stmt.executeUpdate(queryElder);

            ResultSet res = stmt.executeQuery(queryID); // Execute the query
            if(res.next()){
                String queryUsers = "insert into Users (Username, Password, id_Elder) values('"+username+"', '"+password+"', + '"+ res.getString("Id_Elder")+"')"; // Query to check if the user exists

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
