package com.erev.cucei.chat;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SuperiorPane extends HBox {
    public TextField ipTextField;
    public TextField messageTextField;


    public SuperiorPane(){
        setAlignment( Pos.CENTER );
        setSpacing( 20 );

        ipTextField = new TextField();
        addTextLimiter( ipTextField, 16 );
        messageTextField = new TextField();
        addTextLimiter( messageTextField, 25 );

        getChildren().add( new Label("IP: ") );
        getChildren().add( ipTextField );
        getChildren().add( new Label("Message: ") );
        getChildren().add( messageTextField );
    }

    public static void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener( (ov, oldValue, newValue) -> {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
            }
        } );
    }
}
