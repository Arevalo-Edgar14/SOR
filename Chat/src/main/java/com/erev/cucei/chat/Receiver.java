package com.erev.cucei.chat;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver extends Thread {
    private DatagramSocket socketReceiver;
    private static final int DEFAULT_ENTRY_PORT = 3122;
    int entryPort;

    TextArea textArea;

    public Receiver() {
        this( DEFAULT_ENTRY_PORT );
    }

    public Receiver(int entryPort) {
        this.entryPort = entryPort;
    }

    public Receiver(TextArea textArea) {
        this();
        this.textArea = textArea;
    }

    public Receiver(int entryPort, TextArea textArea) {
        this( entryPort );
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            socketReceiver = new DatagramSocket( entryPort );
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[1024];

        DatagramPacket dp = new DatagramPacket( buffer, buffer.length );

        while (true) {
            try {
                socketReceiver.receive( dp );
                textArea.appendText(
                  "Sender IP: " + dp.getAddress().getHostAddress() + ": " +
                    new String( buffer, 0, dp.getLength() ) + "\n" );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public int getEntryPort() {
        return entryPort;
    }

    public void setEntryPort(int entryPort) {
        this.entryPort = entryPort;
    }
}
