package com.erev.cucei.conversor;

public class Conversor {
    public static void main(String[] args) {
        byte b = (byte) 0xF3;
        short s = (short) 0x7A7A;
        int i = 0x7A7A7A7A;
        long l = 0X7A7A7A7A7A7A7A7AL;

        print( serialize( b ) );
        print( serialize( s ) );
        print( serialize( i ) );
        print( serialize( l ) );
    }

    private static void print(char[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            if (i % Byte.SIZE == 0) System.out.print( " | " );
            System.out.print( bytes[i] );
        }
        System.out.println( " | " );
    }

    static char[] serialize(byte by) {
        int aux = 0x80;
        char[] bits = new char[Byte.SIZE];
        for (int i = 0; i < Byte.SIZE; i++) {
            if ((by & aux) == 0) bits[i] = '0';
            else bits[i] = '1';
            aux >>>= 1;
        }
        return bits;
    }

    static char[] serialize(short sh) {
        int aux = 0x8000;
        char[] bits = new char[Short.SIZE];
        for (int i = 0; i < Short.SIZE; i++) {
            if ((sh & aux) == 0) bits[i] = '0';
            else bits[i] = '1';
            aux >>>= 1;
        }
        return bits;
    }

    static char[] serialize(int in) {
        int aux = 0x80000000;
        char[] bits;
        bits = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((in & aux) == 0) bits[i] = '0';
            else bits[i] = '1';
            aux >>>= 1;
        }
        return bits;
    }

    static char[] serialize(long lo) {
        long aux = 0x8000000000000000L;
        char[] bits = new char[Long.SIZE];
        for (int i = 0; i < Long.SIZE; i++) {
            if ((lo & aux) == 0) bits[i] = '0';
            else bits[i] = '1';
            aux >>>= 1;
        }
        return bits;
    }
}
