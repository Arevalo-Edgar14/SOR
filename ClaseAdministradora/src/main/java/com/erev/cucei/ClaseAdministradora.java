package com.erev.cucei;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClaseAdministradora {
    Hashtable<Integer,Matter> table = new Hashtable<>();
    private int counter = 1;

    public static void main(String[] args) {
        ClaseAdministradora admin = new ClaseAdministradora();
        Scanner sn = new Scanner( System.in );

        System.out.println( "Actividad de Clase #8" );

        admin.add( "I7029", "SISTEMAS OPERATIVOS" );
        admin.add( "I7030", "SEMINARIO DE SISTEMAS OPERATIVOS" );
        admin.add( "I7033", "SISTEMAS OPERATIVOS DE RED" );
        admin.add( "I7034", "SEMINARIO DE SISTEMAS OPERATIVOS DE RED" );

        boolean exit_app = false;
        int option;

        while (!exit_app) {
            System.out.println( "Que desea hacer: " );
            System.out.println( "1. Alta materia" );
            System.out.println( "2. Baja materia" );
            System.out.println( "3. Consultar materia" );
            System.out.println( "4. Imprimir tabla" );
            System.out.println( "5. Salir" );

            System.out.println( "Escribe una de las opciones" );
            try {
                option = sn.nextInt();
            } catch (InputMismatchException ex) {
                option = 0;
                sn.next(); // flush to avoid getting cycled
            }

            switch (option) {
                case 1 -> {
                    System.out.println( "Alta materia" );
                    System.out.println( "Ingresa la clave de la materia" );
                    String id = sn.next();
                    System.out.println( "Ingresa el nombre de la materia" );
                    String name = sn.next();
                    int sequentialId = admin.add( id, name );
                }
                case 2 -> {
                    System.out.println( "Baja materia" );
                    System.out.println( "Dame el id de la materia a " +
                                          "eliminar" );
                    int id;
                    try {
                        id = sn.nextInt();
                    } catch (InputMismatchException ex) {
                        id = 0;
                        sn.next(); // flush to avoid getting cycled
                    }
                    admin.delete( id );
                }
                case 3 -> {
                    System.out.println( "Consulta materia" );
                    System.out.println( "Dame el id de la materia a " +
                                          "consultar" );
                    int id;
                    try {
                        id = sn.nextInt();
                    } catch (InputMismatchException ex) {
                        id = 0;
                        sn.next();
                    }
                    Matter matter = admin.select( id );
                    System.out.println( matter );
                }
                case 4 -> admin.print();
                case 5 -> exit_app = true;
                default -> System.out.println( "Opción incorrecta solo " +
                                                 "números entre 1 y 5" );
            }
        }
    }

    private void delete(int id) {
        table.remove( id );
        print();
    }

    private Matter select(int id) {
        return table.get( id );
    }

    private int add(String id, String name) {
        table.put( counter, new Matter( id, name ) );
        print();
        return counter++;
    }

    private void print() {
        String sequential = "Id Secuencial";
        String id = "Clave";
        String name = "Nombre materia";

        var max_size_wrapper = new Object() {
            int sequential_wrapp = sequential.length();
            int id_wrap = id.length();
            int name_wrap = name.length();
        };

        table.forEach( (sequential_, matter) -> {
            int sequential_id_size = sequential_.toString().length();
            int id_size = matter.getId().length();
            int name_size = matter.getName().length();
            if (sequential_id_size > max_size_wrapper.sequential_wrapp)
                max_size_wrapper.sequential_wrapp = sequential_id_size;
            if (id_size > max_size_wrapper.id_wrap)
                max_size_wrapper.id_wrap = id_size;
            if (name_size > max_size_wrapper.name_wrap)
                max_size_wrapper.name_wrap = name_size;
        } );

        System.out.println(
          formatRow( sequential, id, name, max_size_wrapper.sequential_wrapp,
                     max_size_wrapper.id_wrap, max_size_wrapper.name_wrap ) );

        table.forEach( (sequential_, matter) -> System.out.println(
          formatRow( sequential_.toString(), matter.getId(),
                     matter.getName(), max_size_wrapper.sequential_wrapp,
                     max_size_wrapper.id_wrap, max_size_wrapper.name_wrap ) ) );
    }

    private static String formatRow(String sequential, String id,
                                    String name, int sequential_max_size,
                                    int id_max_size, int name_max_size) {
        String row = formatCel( sequential, sequential_max_size );
        row += " | ";
        row += formatCel( id, id_max_size );
        row += " | ";
        row += formatCel( name, name_max_size );
        return row;
    }

    private static String formatCel(String string, int max_size) {
        StringBuilder stringBuilder = new StringBuilder( string );
        stringBuilder.append( " ".repeat( Math.max( 0, max_size - stringBuilder.length() ) ) );
        string = stringBuilder.toString();
        return string;
    }
}
