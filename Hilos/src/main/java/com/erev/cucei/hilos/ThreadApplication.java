package com.erev.cucei.hilos;

import javafx.application.Application;
import javafx.application.Platform;
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

    @Override
    public void stop() {
        // add this because the controller custom constructor adding makes the
        // life-cycle of the Application class change as normal, so to void
        // close the window and continue running the program override this
        // method @see https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html
        // @see https://stackoverflow.com/questions/26619566/javafx-stage-close-handler
        Platform.exit();
        System.exit( 0 );
    }

    public static void main(String[] args) {
        launch();
    }
}