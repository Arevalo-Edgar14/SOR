package com.erev.cucei.tokyo2020;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Tokyo2020Controller {
    public Button secondButton;
    public Button thirdButton;
    public Button readyButton;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private BorderPane borderPane;

    public void onReadyButtonClick(ActionEvent event) {
        textArea.appendText( textField.getText() + '\n' );
    }

    public void secondButtonClick(ActionEvent event) {
    }

    public void thirdButtonClick(ActionEvent event) {
        borderPane.setPrefSize( 777,777 );
    }
}
