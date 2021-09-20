package com.erev.cucei.hilos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThreadApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( ThreadApplication.class.getResource( "thread-view.fxml" ) );
        ThreadController controller = new ThreadController();
        fxmlLoader.setController( controller );
        Scene scene = new Scene( fxmlLoader.load(), 300, 300 );
        stage.setTitle( "Manejo de hilos" );
        stage.setScene( scene );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}