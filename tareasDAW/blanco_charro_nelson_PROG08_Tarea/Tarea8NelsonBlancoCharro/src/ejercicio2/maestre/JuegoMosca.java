package ejercicio2.maestre;

import java.util.Scanner;

/**
 * Clase JuegoMosca
 *
 * @author Nelson Blanco Charro
 * @date 16/03/2022
 */
public class JuegoMosca {

    /*
    * @attribute posicionMosca Array con la posicion de la mosca
    * @attribute Mosca Posicion de la mosca
    * @attribute rondas Cantidad de rondas jugando
    * @attribute victoria Establece si se ha ganado el juego
     */
    static int[] posicionMosca = {0, 0, 0, 0, 0, 0, 0, 0};
    static int mosca = 0;
    static int rondas = 0;
    static boolean victoria = false;

    /*
    * Metodo que permite jugar al juego de cazar la mosca
     */
    public static void main() throws Exception {
        try {
            cambiarMosca();
            Scanner teclado = new Scanner(System.in);
            int posicionUsuario;
            while (rondas < 5) {
                rondas++;
                System.out.println("Introduzca la posicion de la mosca ( 1 - 8 )");
                posicionUsuario = Integer.parseInt(teclado.nextLine());
                while (posicionUsuario < 1 || posicionUsuario > 8) {
                    System.err.println("Por favor, introduzca una posicion valida entre la posicion 1 y la posicion 8");
                    posicionUsuario = Integer.parseInt(teclado.nextLine());
                }
                comprobarPosicion(posicionUsuario - 1);
                if (victoria) {
                    System.out.println("Ha tardado " + rondas + " rondas en cazar la mosca");
                    break;
                }
                if (rondas == 5) {
                    System.err.println("No ha conseguido cazar la mosca, intentelo de nuevo.");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("No se ha introducido un numero");
        }
    }

    /*
    Metodo que aleatoriza la posicion de la mosca
     */
    private static void cambiarMosca() {
        // Establecer la posicion de la mosca aleatoriamente
        mosca = (int) Math.round(Math.random() * 7);
        posicionMosca[mosca] = 1;
    }

    /*
    * Metodo para comprobar que la posicion introducida por el usuario caza o no la mosca
    * @param valor posicion introducida por el usuario para cazar la mosca
     */
    private static void comprobarPosicion(int valor) {
        // Comprobamos que los valores de las casillas adyacentes no excedan las dimensiones del array
        int limiteIzq = valor - 1;
        if (limiteIzq < 0) {
            limiteIzq = 0;
        }
        int limiteDer = valor + 1;
        if (limiteDer > 7) {
            limiteDer = 7;
        }
        // Comprobamos si la posicion introducida por el usuario caza la mosca, o la mosca esta adyacente o lejos
        if (posicionMosca[valor] == 1) {
            System.err.println("La mosca ha sido cazada. ENHORABUENA!");
            victoria = true;
        } else if (posicionMosca[limiteIzq] == 1 || posicionMosca[limiteDer] == 1) {
            System.err.println("La ha revoloteado y se ha colocado en otra posicion");
            posicionMosca[mosca] = 0;
            cambiarMosca();
        } else {
            System.out.println("La mosca sigue donde estaba.");
        }

    }

}
