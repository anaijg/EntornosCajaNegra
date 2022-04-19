import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase contiene las pruebas de los métodos de la clase CompruebaIdentificador.java
 * @author Ana I. Jimenez
 * @see <a href=https://docs.google.com/spreadsheets/d/13zFG3OZrAaGGu_8QyhxKJRBH5kV2LzQj/edit#gid=1911908099>Casos</a>
 *
 */

class CompruebaIdentificadorTest {

    @Test
    @DisplayName("Entre 5 y 15 caracteres")
    void comprobarLongitud() {
        assertEquals(true, CompruebaIdentificador.comprobarLongitud("Num-1---d3")); // (1)
        assertEquals(false, CompruebaIdentificador.comprobarLongitud("Nd3")); // (2)
        assertEquals(false, CompruebaIdentificador.comprobarLongitud("Num-1-letr3--d32")); // (3)
    }

    @Test
    @DisplayName("El identificador debe estar formado por letras, dígitos y guión")
    void comprobarJuegoDeCaracteres() {
        assertEquals(true, CompruebaIdentificador.comprobarJuegoDeCaracteres("Num-1---d3")); // 4
        assertEquals(false, CompruebaIdentificador.comprobarJuegoDeCaracteres("Nu%m-1---d3")); // 5
    }

    @Test
    @DisplayName("El guión no puede estar al principio ni al final.")
    void guionesCorrectos() {
        assertEquals(true, CompruebaIdentificador.guionesCorrectos("Num-1---d3")); // 6
        assertEquals(false, CompruebaIdentificador.guionesCorrectos("-um-1---d3")); // 7
        assertEquals(false, CompruebaIdentificador.guionesCorrectos("num-1---d3-")); // 8

    }

    @Test
    @DisplayName("Debe contener al  menos un carácter  alfabético")
    void caracterAlfabetico() {
        assertEquals(true, CompruebaIdentificador.caracterAlfabetico("Num-1---d3")); // 9
        assertEquals(false, CompruebaIdentificador.caracterAlfabetico("456-1---23")); // 10
    }

    @Test
    @DisplayName("No puede usar palabras reservadas")
    void comprobarPalabraReservada() {
        assertEquals(true, CompruebaIdentificador.comprobarPalabraReservada("Num-1---d3")); // 11
        assertEquals(false, CompruebaIdentificador.comprobarPalabraReservada("integer")); // 12
    }
}