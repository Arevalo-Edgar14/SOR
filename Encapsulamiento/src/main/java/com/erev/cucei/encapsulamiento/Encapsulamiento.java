package com.erev.cucei.encapsulamiento;

import java.util.Scanner;

public class Encapsulamiento {

    public static void main(String[] args) {
        Scanner sn = new Scanner( System.in );

        System.out.println( "Actividad de Clase #1" );

        MyDate my_date = new MyDate();

        boolean exit_app = false;
        int option;

        while (!exit_app) {
            System.out.println( "Fecha acutal " + my_date );
            System.out.println( "1. Cambiar Día" );
            System.out.println( "2. Cambiar Mes" );
            System.out.println( "3. Cambiar Año" );
            System.out.println( "4. Salir" );

            System.out.println( "Escribe una de las opciones" );
            option = sn.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println( "Nuevo día" );
                    if (my_date.setDay( sn.nextInt() )) {
                        System.out.println( "Nuevo día definido" );
                    } else {
                        System.out.println( "Nuevo día invalido" );
                    }
                }
                case 2 -> {
                    System.out.println( "Nuevo mes" );
                    if (my_date.setMonth( sn.nextInt() )) {
                        System.out.println( "Nuevo mes definido" );
                    } else {
                        System.out.println( "Nuevo mes invalido" );
                    }
                }
                case 3 -> {
                    System.out.println( "Nuevo año" );
                    if (my_date.setYear( sn.nextInt() )) {
                        System.out.println( "Nuevo año definido" );
                    } else {
                        System.out.println( "Nuevo año invalido" );
                    }
                }
                case 4 -> exit_app = true;
                default -> System.out.println( "Opción incorrecta solo números entre 1 y 4" );
            }
        }
    }
}
