package com.erev.cucei.encapsulamiento;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test MyDate and confirm makes correct validation")
public class MyDateTest {
    MyDate my_date;

    @BeforeEach
    void setUp() {
        my_date = new MyDate();
    }

    @AfterEach
    void tearDown() {
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Constructor {
        @Test
        @DisplayName("Test default day is set ")
        void get_day() {
            assertEquals( 1, my_date.getDay() );
        }

        @Test
        @DisplayName("Test default month is set ")
        void get_month() {
            assertEquals( 1, my_date.getMonth() );
        }

        @Test
        @DisplayName("Test default year is set ")
        void get_year() {
            assertEquals( 1970, my_date.getYear() );
        }

        @Test
        @DisplayName("Test format with default date")
        void format() {
            assertEquals( "1/Enero/1970", my_date.toString( true ) );
        }

        @Test
        @DisplayName("Test default date is set and toString format works")
        void constructor() {
            assertEquals( "1/1/1970", my_date.toString() );
            assertEquals( 1, my_date.getDay() );
            assertEquals( 1, my_date.getMonth() );
            assertEquals( 1970, my_date.getYear() );
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_supported {

        @DisplayName("A zero value for year is supported.")
        @Test
        void if_it_is_zero() {
            assertTrue( my_date.setYear( 0 ) );
        }

        @DisplayName("A negative value for year is supported because we can have AC dates.")
        @ParameterizedTest(name = "For example, year {0} is supported and will be year {0}AC.")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
            assertTrue( my_date.setYear( year ) );
        }

        @DisplayName("A positive value for year is supported.")
        @ParameterizedTest(name = "For example, year {0} is supported and will be year {0} BC.")
        @ValueSource(ints = {1, 12, 1846, 2001, 2021})
        void if_it_is_positive(int year) {
            assertTrue( my_date.setYear( year ) );
        }
    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_a_leap_year {

        @DisplayName("A leap year is the one that is divisible by 4 but not by 100.")
        @ParameterizedTest(name = "For example, year {0} is supported and will be year 1 BC.")
        @ValueSource(ints = {2100, 2200})
        void if_it_is_divisible_by_4_but_not_by_100(int year) {
            assertFalse( MyDate.isLeap( year ) );
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {0, 4, 16, 2012, 2016, 2020, 2024, 2048, 2400})
        void if_it_is_one_of_the_following_years(int year) {
            assertTrue( MyDate.isLeap( year ) );
        }

    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_month_is_not_supported {
        @DisplayName("A negative value for month is not supported.")
        @ParameterizedTest(name = "For example, month {0} is not supported.")
        @ValueSource(ints = {-1, -20, -50, -12})
        void if_it_is_negative(int month) {
            assertFalse( my_date.setMonth( month ) );
        }

        @DisplayName("A zero value for month is not supported.")
        @Test
        void if_it_is_zero() {
            assertFalse( my_date.setMonth( 0 ) );
        }

        @DisplayName("A Positive value bigger than 12 for month is not supported.")
        @ParameterizedTest(name = "For example, month {0} is not supported.")
        @ValueSource(ints = {13, 20, 50})
        void if_it_is_bigger_than_12(int month) {
            assertFalse( my_date.setMonth( month ) );
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_day_is_not_supported {
        @DisplayName("A negative value for day is not supported.")
        @ParameterizedTest(name = "For example, day {0} is not supported.")
        @ValueSource(ints = {-1, -20, -50, -12})
        void if_it_is_negative(int day) {
            assertFalse( my_date.setDay( day ) );
        }

        @DisplayName("A zero value for day is not supported.")
        @Test
        void if_it_is_zero() {
            assertFalse( my_date.setDay( 0 ) );
        }

        @DisplayName("A Positive value bigger than 31 for day is not supported.")
        @ParameterizedTest(name = "For example, day {0} is not supported.")
        @ValueSource(ints = {32, 50, 65})
        void if_it_is_bigger_than_31(int day) {
            assertFalse( my_date.setDay( day ) );
        }

        @DisplayName("Months with 30 days try to set 31 days.")
        @ParameterizedTest(name = "Month {0} don't have 31 days.")
        @ValueSource(ints = {4, 6, 9, 11})
        void if_is_between_1_and_30(int month) {
            assertAll( () -> {
                assertTrue( my_date.setMonth( month ) );
                assertFalse( my_date.setDay( 31 ) );
            } );
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_day_is_supported {
        @DisplayName("Months has valid from 1 to 31.")
        @ParameterizedTest(name = "For example, month {0} has valid days from 1 to 31.")
        @ValueSource(ints = {1, 3, 5, 7, 8, 10, 12})
        void if_is_between_1_and_31(int month) {
            assertAll( () -> {
                assertTrue( my_date.setMonth( month ) );
                assertAll(
                  "Month " +
                    MyDate.MONTHS[month - 1] +
                    " between_1_and_31",
                  () -> IntStream.rangeClosed( 1, 31 )
                                 .forEach( j -> assertTrue( my_date.setDay( j ) ) ) );
            } );
        }

        @DisplayName("Months has valid from 1 to 30.")
        @ParameterizedTest(name = "For example, month {0} has valid days from 1 to 30.")
        @ValueSource(ints = {4, 6, 9, 11})
        void if_is_between_1_and_30(int month) {
            assertAll( () -> {
                assertTrue( my_date.setMonth( month ) );
                assertAll(
                  "Month " +
                    MyDate.MONTHS[month - 1] +
                    " between_1_and_30",
                  () -> IntStream.rangeClosed( 1, 30 )
                                 .forEach( j -> assertTrue( my_date.setDay( j ) ) ) );
            } );
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class February {
        @BeforeEach
        void setUp() {
            my_date.setMonth( 2 );
        }

        @DisplayName("February has valid days from 1 to 28.")
        @Test
        void from_1_to_28_days() {
            assertAll( () -> IntStream.rangeClosed( 1, 28 )
                                      .forEach( i -> assertTrue( my_date.setDay( i ) ) ) );
        }

        @DisplayName("If is not leap year.")
        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {2100, 2200, 2300})
        void if_is_not_leap_year(int year) {
            assertAll( "not leap year",
                       () -> assertTrue( my_date.setYear( year ) ),
                       () -> assertFalse( my_date.setDay( 29 ) )
            );
        }

        @DisplayName("If is leap year.")
        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {0, 4, 16, 2012, 2016, 2020, 2024, 2048, 2400})
        void if_is_leap_year(int year) {
            assertAll( "not leap year",
                       () -> assertTrue( my_date.setYear( year ) ),
                       () -> assertTrue( my_date.setDay( 29 ) )
            );
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class FromValidDateToInvalidDate {

        @ParameterizedTest(name = "Month {0} has not 31 days")
        @ValueSource(ints = {4, 6, 9, 11})
        void from_valid_31_month_to_30_month(int month) {
            assertAll( "not 31 days",
                       () -> assertTrue( my_date.setDay( 31 ) ),
                       () -> assertFalse( my_date.setMonth( month ) )
            );
        }

        @Test
        void from_valid_31_month_to_february() {
            assertAll( "not 31 days",
                       () -> assertTrue( my_date.setDay( 31 ) ),
                       () -> assertFalse( my_date.setMonth( 2 ) )
            );
        }

        @Test
        void from_valid_30_month_to_february() {
            assertAll( "not 30 days",
                       () -> assertTrue( my_date.setDay( 30 ) ),
                       () -> assertFalse( my_date.setMonth( 2 ) )
            );
        }

        @Test
        void from_valid_leap_year_to_not_leap_year() {
            int leapYear = 2020;
            int notLeapYear = 2021;
            assertAll(
              () -> assertTrue( my_date.setMonth( 2 ) ),
              () -> assertTrue( my_date.setYear( leapYear ) ),
              () -> assertTrue( my_date.setDay( 29 ) ),
              () -> assertFalse( my_date.setYear( notLeapYear ) )
            );


        }
    }
}