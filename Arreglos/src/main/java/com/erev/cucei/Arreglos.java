package com.erev.cucei;

import java.util.Random;

public class Arreglos {
    public static void main(String[] args) {
        char[] array;
        Random rand = new Random();
        int MAX = 150;
        int MIN = 1;

        int tam = rand.nextInt( (MAX - MIN) + 1 ) + MIN;

        System.out.println( "Tamaño: " + tam );

        array = new char[tam];

//        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder alphabet = new StringBuilder();
        for (int i = 'A'; i <= 'Z'; i++) alphabet.append( (char) i );

        for (int i = 0; i < tam; i++)
            array[i] = alphabet.charAt( rand.nextInt( alphabet.length() ) );

        System.out.println( array );

        method( array );

        System.out.println( array );
    }

    private static void method(char[] array) {
        String rand_string = "NOHAYEXAMENELVIERNES";

        int free_space = array.length;
        int i = 0;

        while (free_space > rand_string.length()){
            for (char letter: rand_string.toCharArray()){
                array[i] = letter;
                i++;
                free_space--;
            }
        }
    }

}
