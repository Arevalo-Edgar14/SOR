package com.erev.cucei.chat;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ChatView extends VBox {
    public TextArea chatTextArea;
    public Button senderButton;
    public SuperiorPane sp;
    public ChatView(){
        setAlignment( Pos.CENTER );
        chatTextArea = new TextArea();
        chatTextArea.setEditable( false );
        chatTextArea.setDisable( false );
        chatTextArea.setPrefSize( 500, 454 );

        senderButton = new Button("Send");
        senderButton.setPrefWidth( 500 );

        sp = new SuperiorPane();

        getChildren().addAll( sp, chatTextArea, senderButton );
    }
}
