package com.example.project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author james
 */
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 650);
        stage.setResizable(false);
        stage.setTitle("Health app");
        stage.setScene(scene);
        stage.show();
        try {
            Database.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        User.getInstance();


        Thread thread = new Thread(new NotifManager());
        thread.start();

    }

    public static void main(String[] args) {
        launch();
    }
}