package com.erev.cucei.chat;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ChatController {

    ChatController(Stage stage, int receiverPort, int transmitter_port){
        ChatView root = new ChatView();
        Scene scene = new Scene( root, 500, 500); // h w

        stage.setTitle( "Chat Version Premium");
        stage.setScene( scene);

        Receiver receiver = new Receiver( receiverPort, root.chatTextArea );
        receiver.start();

        root.senderButton.setOnAction( event -> {
            String ip = root.sp.ipTextField.getText();
            String message = root.sp.messageTextField.getText();

            byte[] buffer = message.getBytes( StandardCharsets.UTF_8 );

            try {
                DatagramSocket transmitter = new DatagramSocket();
                DatagramPacket dp;
                dp = new DatagramPacket( buffer, buffer.length,
                                         InetAddress.getByName( ip ),
                                         transmitter_port);
                transmitter.send( dp );
                transmitter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        stage.show();

    }
}