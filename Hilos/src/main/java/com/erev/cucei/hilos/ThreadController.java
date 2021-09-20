package com.erev.cucei.hilos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ThreadController implements Initializable {
    @FXML
    public TextArea firstTextArea;

    @FXML
    public TextArea secondTextArea;

    @FXML
    public Button onActionButton;

    CustomThread thread1;
    CustomThread thread2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        onActionButton.setOnAction( event1 -> {
            if (thread1.isRunning())
                thread1.toggleState();
            else
                thread1.play();
        } );
        thread1 = new CustomThread( 1000, firstTextArea );
        thread2 = new CustomThread( 2000, secondTextArea );
        thread1.start();
        thread2.start();
    }
}