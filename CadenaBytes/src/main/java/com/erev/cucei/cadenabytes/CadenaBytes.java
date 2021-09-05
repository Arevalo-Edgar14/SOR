package com.erev.cucei.cadenabytes;

import java.nio.charset.StandardCharsets;

public class CadenaBytes {
    public static void main(String[] args) {
        byte[] array;

        // less than 126 characters because is saved on a byte
        String string = "HOY ES VIERNES 20 DE AGOSTO Y ESTAMOS EN CLASES EN " +
          "LINEA";
        array = packageBuilder( string );
        printPackage( array );

        String unpacked = unpacked( array );
        printUnpackage(unpacked);
    }

    static String unpacked(byte[] array){
        return new String(array, 1, array[0]);
    }

    static void printPackage(byte[] array){
        for (byte b : array)
            System.out.print( " " + b + " " );
        System.out.println();
    }

    static void printUnpackage(String unpacked){
        System.out.println(unpacked);
    }

    static byte[] packageBuilder(String string){
        // we will save the string size + the bytes (ASCII code) of the string
        byte[] to_package = new byte[string.length() + 1];

        // length return int so explicit cast need
        to_package[0] = (byte) string.length();

        // copy the to_package of bytes from string for the start, to the to_package at
        // pos 1 to the end of the string length
        System.arraycopy( string.getBytes( StandardCharsets.UTF_8 ), 0, to_package
          ,1, string.length() );
        return to_package;
    }
}
