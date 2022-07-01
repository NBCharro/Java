package ejercicio3.maestre;

import java.util.Scanner;

/**
 * Clase Multidimensional
 *
 * @author Nelson Blanco Charro
 * @date 16/03/2022
 */
public class Multidimensional {

    /*
    * Metodo que calculara los maximos de cada fila y la media de los maximos de un Array multidimensional aleatorio
     */
    public static void main() throws Exception {
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduzca la dimension de la matriz creada aleatoriamente ( N x N)");
            int dimension = Integer.parseInt(teclado.nextLine());
            while (!(dimension >= 1)) {
                System.err.println("Por favor introduzca un valor valido. Numero mayor o igual a 1.");
                dimension = Integer.parseInt(teclado.nextLine());
            }
            // Creacion de la matriz
            int[][] matriz = new int[dimension][dimension];
            for (int[] matriz1 : matriz) {
                for (int y = 0; y < matriz1.length; y++) {
                    matriz1[y] = (int) (Math.random() * 9);
                }
            }
            // Maximo de cada fila
            int[] maximo = new int[dimension];
            for (int i = 0; i < maximo.length; i++) {
                maximo[i] = MaximoFila(matriz, i);
            }
            // Mostrar matriz
            System.out.println("La matriz creada aleatoriamente es");
            verMatriz(matriz);
            // Mostrar maximo de cada fila
            verMaximo(maximo);
            // Media de los maximos
            System.out.println("La media de los maximos es de " + mediaMaximos(maximo));
        } catch (NumberFormatException e) {
            throw new Exception("No se ha introducido un numero");
        }
    }

    /*
    * Metodo para calcular el maximo de una fila en un array multidimensional
    * @param matriz Matriz para calcular el maximo de la fila
    * @param fila Numero de la fila en la que se calculara el valor maximo
    * @return maximo Valor maximo de la fila a calcular
     */
    private static int MaximoFila(int[][] matriz, int fila) {
        int maximo = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[fila][i] > maximo) {
                maximo = matriz[fila][i];
            }
        }
        return maximo;
    }

    /*
    * Metodo para calcular el valor medio de un array
    * @param array Array que se calculara el valor medio
    * @return media Valor medio de los valores del array
     */
    private static double mediaMaximos(int[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        double media = suma / array.length;
        return media;
    }

    /*
    * Metodo para mostrar la matriz creada aleatoriamente
    * @param matriz Matriz que se mostrara
     */
    private static void verMatriz(int[][] matriz) {
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                System.out.print(matriz1[j] + " ");
            }
            System.out.println();
        }
    }

    /*
    * Metodo para ver el array de los maximos de la matriz creada aleatoriamente
    * @param array Array que calculara la media de sus valores
     */
    private static void verMaximo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("El maximo de la fila " + (i + 1) + " es " + array[i]);
        }
    }
}
