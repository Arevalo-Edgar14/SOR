package com.erev.cucei.tokyo2020;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Tokyo2020Application extends Application {


    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(
          Tokyo2020Application.class.getResource(
            "/com.erev.cucei.tokyo2020/tokyo2020.fxml" )
        );
        try {
            final Parent parent = fxmlLoader.load();

            // send primary stage to controller to can control the resize
            Tokyo2020Controller controller = fxmlLoader.getController();
            controller.setStage(primaryStage);

            final Scene scene = new Scene( parent, 202, 202 );
            primaryStage.setResizable( true );
            primaryStage.setTitle( "Edgar + Alexa Moreno" );
            primaryStage.setScene( scene );
            primaryStage.hide();
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println( "Error displaying the window" );
            throw new RuntimeException( ex );
        }
    }

    public static void main(String[] args) {
        launch( args );
    }
}
