package inicio.maestre;

import ejercicio1.maestre.UtilidadesCadenas;
import ejercicio2.maestre.JuegoMosca;
import ejercicio3.maestre.Multidimensional;
import ejercicio4.maestre.CuerposCelestes;
import ejercicio5.maestre.MasterMind;

/**
 *
 * @author Nelson Blanco Charro
 * @date 16/03/2022
 */
public class Main {

    public static void main(String[] args) {
        try {
// 1. Operaciones con cadenas.
            ejercicio1();
// 2. Operaciones con arrays unidimensionales.
            ejercicio2();
// 3. Operaciones con arrays multidimensionales.
            ejercicio3();
// 4. Operaciones con ArrayList.
            ejercicio4();
// 5. VOLUNTARIO: Juego del MasterMind
            ejercicio5();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void ejercicio1() {
        System.out.println("----- Ejercicio 1 -----");
        // He creado tantas variables porque creo que se ve de forma mas clara de esta forma.
        // Se podria hacer de forma mas rapida y sencilla sacandolo por consola directamente, pero he querido crear las variables porque no se si en el trabajo es mejor crear las variables por si en el futuro accedes a ellas, aunque los String se van creando y las modificaciones crean nuevos Strings.
        // Union de dos cadenas
        String union1 = "Frase numero 1";
        String union2 = "Frase numero 2";
        String unionFrases = UtilidadesCadenas.unionCadenas(union1, union2);
        System.out.println(unionFrases);
        // Contar numero de veces que aparece una letra en una frase
        String frase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        char letra = 'a';
        int numeroVeces = UtilidadesCadenas.cantidadChar(frase, letra);
        System.out.println("La cantidad de veces que aparece la letra '" + letra + "' en la frase es de " + numeroVeces + " veces");
        // Verificar si una frase es palindroma
        String palindroma = "Otto";
        if (UtilidadesCadenas.esPalindroma(palindroma)) {
            System.out.println("La frase es palindroma");
        } else {
            System.out.println("La frase NO es palindroma");
        }
        // Girar una frase
        String fraseGirar = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        System.out.println(UtilidadesCadenas.girarFrase(fraseGirar));
    }

    private static void ejercicio2() throws Exception {
        System.out.println("----- Ejercicio 2 -----");
        JuegoMosca.main();
    }

    private static void ejercicio3() throws Exception {
        System.out.println("----- Ejercicio 3 -----");
        Multidimensional.main();
    }

    private static void ejercicio4() throws Exception {
        System.out.println("----- Ejercicio 4 -----");
        CuerposCelestes.main();
    }

    private static void ejercicio5() throws Exception {
        System.out.println("----- Ejercicio 5 -----");
        MasterMind.main();
    }
}
