package ejercicio5.maestre;

import java.util.Scanner;

/**
 *
 * @author Nelson Blanco Charro
 * @date 17/03/2022
 */
public class MasterMind {

    /*
    * @attribute numerosOcultos Array de numeros generados aleatoriamente
    * @attribute rondas Numero de rondas de juego
    * @attribute victoria Booleano para comprobar si se han conseguido adivinar los numeros
     */
    static int[] numerosOcultos = {0, 0, 0};
    static int rondas = 0;
    static boolean victoria = false;

    /*
    * Metodo para iniciar a jugar
     */
    public static void main() throws Exception {
        try {
            aleatorio();
            // Bucle para ver los numeros creados aleatoriamente
            for (int numerosOculto : numerosOcultos) {
                System.out.print(numerosOculto + " - ");
            }
            preguntar();
        } catch (NumberFormatException e) {
            throw new Exception("No se ha introducido un numero");
        }
    }

    /*
    * Metodo para aleatorizar los 3 numeros del array
     */
    private static void aleatorio() {
        int numero;
        for (int i = 0; i < 3; i++) {
            numero = (int) (Math.random() * 10);
            numerosOcultos[i] = numero;
        }
    }

    /*
    * Metodo para obtener los tres numeros introducidos por teclado del usuario
     */
    private static void preguntar() {
        Scanner teclado = new Scanner(System.in);
        int[] posicionUsuario = new int[3];
        while (rondas < 7) {
            System.err.println("RONDA NUMERO " + (rondas + 1));
            rondas++;
            for (int i = 0; i < 3; i++) {
                System.out.println("Introduzca el numero " + (i + 1) + " ( 0 - 9 )");
                posicionUsuario[i] = Integer.parseInt(teclado.nextLine());
                while (posicionUsuario[i] < 0 || posicionUsuario[i] > 9) {
                    System.err.println("Por favor, introduzca una posicion valida entre la posicion 0 y la posicion 9");
                    posicionUsuario[i] = Integer.parseInt(teclado.nextLine());
                }
            }
            comprobarPosicion(posicionUsuario);
            if (victoria) {
                System.err.println("Ha adivinado los numeros. ENHORABUENA!");
                System.err.println("Ha tardado " + rondas + " rondas en adivinar los numeros");
                break;
            }
            if (rondas == 7) {
                System.err.println("No ha conseguido adivinar los numeros, intentelo de nuevo.");
            }
        }
    }

    /*
    * Metodo para verificar que los numeros introducidos por el usuario sean los mismos que los generados aleatoriamente
     */
    private static void comprobarPosicion(int[] valor) {
        String[] posicion = new String[3];
        //  Numero 1
        if (valor[0] == numerosOcultos[0]) {
            posicion[0] = "v";
        } else if (valor[0] == numerosOcultos[1] || valor[0] == numerosOcultos[2]) {
            posicion[0] = "a";
        } else {
            posicion[0] = "r";
        }
        // Numero 2
        if (valor[1] == numerosOcultos[1]) {
            posicion[1] = "v";
        } else if (valor[1] == numerosOcultos[0] || valor[1] == numerosOcultos[2]) {
            posicion[1] = "a";
        } else {
            posicion[1] = "r";
        }
        if (valor[2] == numerosOcultos[2]) {
            posicion[2] = "v";
        } else if (valor[2] == numerosOcultos[0] || valor[2] == numerosOcultos[1]) {
            posicion[2] = "a";
        } else {
            posicion[2] = "r";
        }
        // Mensaje de pista o victoria
        if (posicion[0].equals("v") && posicion[1].equals("v") && posicion[2].equals("v")) {
            victoria = true;
        } else {
            System.out.println("Pista");
            System.out.println(valor[0] + " - " + valor[1] + " - " + valor[2] + " // " + posicion[0] + " - " + posicion[1] + " - " + posicion[2]);
            System.out.println("");
        }
    }
}
