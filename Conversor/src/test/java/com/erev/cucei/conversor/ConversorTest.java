package com.erev.cucei.conversor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing more options from the convertor")
public class ConversorTest {

    @ParameterizedTest(name = "Byte {0}.")
    @ValueSource(bytes = {0x00, (byte) 0xF3, 0x20, (byte) 0x80, (byte) 0xA9,
      (byte) 0xFF, 0x75, 0x35})
    void bytes_serialization(byte b) {
        String aux = String.format( "%8s", Integer.toBinaryString( b & 0xFF ) )
                           .replace( ' ', '0' );
        assertEquals( aux, String.valueOf( Conversor.serialize( b ) ) );
    }

    @ParameterizedTest(name = "Short {0}.")
    @ValueSource(shorts = {0x0000, 0x7A7A, 0x1234, (short) 0x8080,
      (short) 0xFFFF, (short) 0xAEDF, 0x7985, 0x3545})
    void short_serialization(short s) {
        String aux = String.format( "%16s",
                                    Integer.toBinaryString( s & 0xFFFF ) )
                           .replace( ' ', '0' );
        assertEquals( aux, String.valueOf( Conversor.serialize( s ) ) );
    }

    @ParameterizedTest(name = "Integer {0}.")
    @ValueSource(ints = {0x00000000, 0x7A7A7A7A, 0x12345678, 0x80808080,
      0xFFFFFFFF, 0xAEDFC702, 0x79852346, 0x35451784})
    void int_serialization(int i) {
        String aux = String.format( "%32s",
                                    Integer.toBinaryString( i ) )
                           .replace( ' ', '0' );
        assertEquals( aux, String.valueOf( Conversor.serialize( i ) ) );
    }

    @ParameterizedTest(name = "Long {0}.")
    @ValueSource(longs = {0x0000000000000000L, 0x7A7A7A7A7A7A7A7AL,
      0x12345678AEDFC702L, 0x8080808035451784L, 0xFFFFFFFFFFFFFFFFL,
      0xAEDFC70279852346L, 0x79852346AEDFC702L, 0x3545178435451784L})
    void long_serialization(long l) {
        String aux = String.format( "%64s",
                                    Long.toBinaryString( l ) )
                           .replace( ' ', '0' );
        assertEquals( aux, String.valueOf( Conversor.serialize( l ) ) );
    }
}
