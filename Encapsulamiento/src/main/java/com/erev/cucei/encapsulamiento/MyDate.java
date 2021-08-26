package com.erev.cucei.encapsulamiento;

public class MyDate {
    static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
      "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private int day;
    private int month;
    private int year;

    public MyDate() {
        // Defult value January 1, 1970
        this.day = 1;
        this.month = 1;
        this.year = 1970;
    }

    static boolean isLeap(int year) {
        if (year % 4 != 0) return false;

        if (year % 400 == 0) return true;

        return year % 100 != 0;
    }

    private boolean validateDate(int day, int month, int year) {
        return !switch (month) {
            case 2 -> isLeap( year ) ? day <= 29 : day <= 28;
            case 4, 6, 9, 11 -> day < 31;
            default -> true;
        };
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean setDay(int day) {
        if (day < 1 || day > 31) return false;

        if (validateDate( day, month, year )) return false;

        this.day = day;
        return true;
    }

    public boolean setMonth(int month) {
        if (month < 1 || month > 12) return false;

        if (validateDate( day, month, year )) return false;

        this.month = month;
        return true;
    }


    public boolean setYear(int year) {
        if (validateDate( day, month, year )) return false;

        this.year = year;
        return true;
    }

    public String toString(boolean format) {
        if (format) {
            return toStringFormatted();
        }
        return toString();
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public String toStringFormatted() {
        return day + "/" + MONTHS[month - 1] + "/" + year;
    }
}
