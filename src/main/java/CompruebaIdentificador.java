import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;


public class CompruebaIdentificador {

    /**
     * Comprueba que el parámetro id contiene entre 5 y 15 caracteres, ambos inclusive
     * @param id
     * @return
     */
    static boolean comprobarLongitud(String id) {

        return id.length() >= 5 && id.length() <= 15;
    }


    /**
     * Comprueba que todos los caracteres del identificador son: o bien una letra, o bien un dígito, o bien un guión
     * @param id
     * @return
     */
    static boolean comprobarJuegoDeCaracteres(String id) {
        for (int i = 0; i < id.length(); i++) {
            Character c = id.charAt(i);
            if (!isLetter(c) && !isDigit(c) && (c != '-')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Comprueba que el identificador no contiene guiones al principio ni al final
     * @param id
     * @return
     */
    static boolean guionesCorrectos(String id) {

        return !id.startsWith("-") && !id.endsWith("-");
    }


    /**
     * Comprueba que el identificador contiene al menos un carácter alfabético
     * @param id
     * @return
     */
    static boolean caracterAlfabetico(String id) {
        // recorremos el id, y en cuanto encontramos una letra decimos true y salimos
        for (int i = 0; i < id.length(); i++) {
            Character c = id.charAt(i);
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba que el identificador no es una palabra reservada en Java
     * @param id
     * @return
     */
    static boolean comprobarPalabraReservada(String id) {
        String reservadas = "abstract, continue, for, new, switch, assert, default, goto, package, synchronized, boolean, do, if, private, this, break, double, implements, protected, throw, byte, else, import, public, thows, case, enum, instanceof, return, transient, catch, extends, int, short, try, char, final, interface, static, void, class, finally, long, strictfp, volatile, const, float, native, super, while, integer";
        reservadas = reservadas.replace(" ", ""); // quitamos todos los espacios en blanco
        String[] palabrasReservadas = reservadas.split(",");
        for (int i = 0; i < palabrasReservadas.length; i++) {
            if (palabrasReservadas[i].equals(id)) {
                return false;
            }
        }
        return true;
    }



}
