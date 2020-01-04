package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/view/Welcome.fxml").openStream());
        primaryStage.setTitle("Cense: A Calculator for Sensical Personal Finance");
        primaryStage.setScene(new Scene(root, 1024, 768));

        WelcomeController welcomeController = fxmlLoader.getController();
        welcomeController.setStage(primaryStage);

        primaryStage.show();
    }
}
