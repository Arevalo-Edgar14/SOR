package com.erev.cucei.encapsulamiento;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EncapsulationApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( EncapsulationApplication.class.getResource( "encapsulation-view.fxml" ) );
        Scene scene = new Scene( fxmlLoader.load(), 600, 400 );
        stage.setTitle( "Encapsulamiento!" );
        stage.setScene( scene );
        stage.show();
    }
}