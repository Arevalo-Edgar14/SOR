package com.erev.cucei.hilos;

import javafx.scene.control.TextArea;

public class CustomThread extends Thread {
    private final int time;
    private int counter;
    private final TextArea textArea;

    public boolean isRunning() {
        return is_running;
    }

    private boolean is_running = true;

    public CustomThread(int time, TextArea textArea) {
        this.time = time;
        this.textArea = textArea;
    }

    public void toggleState(){
        is_running = !is_running;
    }

    public synchronized void play(){
        toggleState();
        notify();
    }

    @Override
    public void run() {
        while (true) {
            if(!is_running){
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            textArea.appendText( counter++ + "\n" );
            try {
                sleep( time );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
