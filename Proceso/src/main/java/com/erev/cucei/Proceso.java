package com.erev.cucei;

public class Proceso {
    public static void main(String[] args) {
        Proceso p = new Proceso();

        int value = 8;
        int[] reference = new int[1];
        reference[0] = value;

        p.valor( value, value );
        System.out.println( "Valor = " + value );


        p.referencia( reference, reference );
        System.out.println("Valor = " + reference[0]);
    }

    private void referencia(int[] reference, int[] reference1) {
        reference[0] *= reference1[0];
        System.out.println( "Valor = " + reference[0] );

        reference1[0] = reference[0] - reference1[0];
        System.out.println( "Valor = " + reference1[0] );
    }

    private void valor(int valor, int valor1) {
        valor *= valor1;
        System.out.println( "Valor = " + valor );

        valor1 = valor - valor1;
        System.out.println( "Valor = " + valor1 );
    }
}
