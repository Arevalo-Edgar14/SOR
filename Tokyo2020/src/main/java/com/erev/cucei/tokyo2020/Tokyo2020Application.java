package com.erev.cucei.tokyo2020;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Tokyo2020Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( Tokyo2020Application.class
                                                  .getResource(
                                                    "/com.erev.cucei" +
                                                      ".tokyo2020/tokyo2020" +
                                                      ".fxml" ) );
        Scene scene = new Scene( fxmlLoader.load(), 202, 202 );
        stage.setTitle( "Edgar + Alexa Moreno" );
        stage.setScene( scene );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
