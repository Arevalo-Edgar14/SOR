package com.erev.cucei.tokyo2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Tokyo2020Controller {
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        System.out.println( stage );
    }

    public void onReadyButtonClick() {
        if (textField.getText().isEmpty()) return;
        textArea.appendText( textField.getText() + '\n' );
    }

    public void secondButtonClick() {
        if (textField.getText().isEmpty()) return;
        textArea.appendText(
          Arrays.toString( textField.getText()
                                    .getBytes( StandardCharsets.UTF_8 ) )
                .replace( String.valueOf( '[' ), "" )
                .replace( ",", "" )
                .replace( "]", "" ) + '\n'
        );
    }

    public void thirdButtonClick() {
        stage.setHeight( 777 );
        stage.setWidth( 777 );
    }
}
