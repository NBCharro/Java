
import java.util.Scanner;

/**
 *
 * @class PROG02_Ejer09
 * @description Ejercicio 9.
Dise�a un programa Java que solicite un n�mero de 5 d�gitos del teclado, separe el n�mero en sus d�gitos individuales y los muestre por pantalla. Por ejemplo, si el n�mero es 53123 que muestre:

5 3 1 2 3
 * @author Nelson Blanco Charro
 */
public class PROG02_Ejer09 {
    public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        String x;
        System.out.println("Introducir un numero de 5 cifras:");
        x = teclado.nextLine();
        // Se puede hacer de forma mas sencilla, pero utilizare el metodo aprendido en este tema:
        System.out.println(x.length() == 5 ? x.substring(0,1)+" "+x.substring(1,2)+" "+x.substring(2,3)+" "+x.substring(3,4)+" "+x.substring(4,5):"El numero introducido no tiene 5 cifras");
    }
}
