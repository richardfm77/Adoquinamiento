package mx.unam.ciencias;
/**
 * Clase para tener
 * mis porpias utilidades y funciones
 * matemáticas.
 */
public class MathUtils {
    /**
     * Eleva un número
     * {a} a un núemero {b}.
     * De forma entera y positiva.
     * @param a la base.
     * @param b el exponente.
     * @return a^b.
     */
    public static int pow(int a, int b) {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException();
        if (b == 0)
            return 1;
        int result = 1;
            for (int i = 0; i < b; i++) {
            result *= a; 
        }
        return result;
    }

    /**
     * Genera un número pseudoaleatorio,
     * en un cierto rango.
     * @param min el mínimo número a generar.
     * @param max el mayor número a generar.
     * @return
     */
    public static int randomNum(int min, int max) {
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
    
}
