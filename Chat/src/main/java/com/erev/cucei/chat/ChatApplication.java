package com.erev.cucei.chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;


public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) {
        Stage secondStage = new Stage();
        new ChatController( stage, 3122, 3123);
        new ChatController( secondStage, 3123, 3122);
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