
import java.util.Scanner;

/**
 *
 * @class PROG02_Ejer07
 * @description Ejercicio 7.
 * Dise�a un programa Java para resolver una ecuaci�n de primer grado con una inc�gnita (x), suponiendo que los coeficientes de la ecuaci�n (C1 y C2) se introducen desde teclado.
 * C1x + C2 = 0
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer07 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el termino de X: ");
        int C1 = teclado.nextInt();
        System.out.println("Introduczca el termino independiente: ");
        int C2 = teclado.nextInt();
        System.out.println("La ecuacion a resolver es: " + C1 +"x + " + C2 + " = 0");
        System.out.println("El valor de X es: " + -C2/C1);
    }
}
