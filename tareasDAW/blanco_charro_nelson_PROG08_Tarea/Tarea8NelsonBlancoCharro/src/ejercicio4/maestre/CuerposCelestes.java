package ejercicio4.maestre;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase CuerposCelestes
 *
 * @author Nelson Blanco Charro
 * @date 17/03/2022
 */
public class CuerposCelestes {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<CuerpoCeleste06> planetas = new ArrayList();

    /*
    * Metodo main para guardar y mostrar los cuerpos celestes introducidos
     */
    public static void main() throws Exception {
        try {
            leerPlanetas();
            System.out.println("\nPlanetas introducidos:");
            mostrarPlanetas();
        } catch (Exception e) {
            throw new Exception("Ha ocurrido un problema.");
        }
    }

    /*
    * Metodo para mostrar todos los cuerpos celestes introducidos invocando al metodo toString de la clase CuerpoCeleste06
     */
    public static void mostrarPlanetas() {
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println(planetas.get(i));
        }
    }

    /*
    * Metodo para leer por teclado los cuerpos celestes introducidos por el usuario y guardarlos en un Arraylist.
     */
    public static void leerPlanetas() {

        /*
        * @attribute codigoCuerpo Codigo del cuerpo celeste
        * @attribute nombre Nombre del cuerpo celeste
        * @attribute tipoObjeto Tipo de objeto del cuerpo celeste
        * @attribute diametro Diametro del cuerpo celeste
        * @attribute salir Atributo para verificar en el While si se quiere dejar de introducir cuerpos celestes
        * @attribute respuesta String para guardar la respuesta del usuario cuando se le pregunta si quiere salir.
        * @object aux Variable que tendra la referencia de cada cuerpo celeste
         */
        String codigoCuerpo;
        String nombre;
        String tipoObjeto;
        int diametro;
        boolean salir = false;
        String respuesta;
        CuerpoCeleste06 aux;

        while (!salir) {
            System.out.print("Codigo del cuerpo celeste: ");
            codigoCuerpo = sc.nextLine();
            System.out.print("Nombre del cuerpo celeste: ");
            nombre = sc.nextLine();
            System.out.print("Tipo de objeto: ");
            tipoObjeto = sc.nextLine();
            System.out.print("Diametro: ");
            diametro = sc.nextInt();
            sc.nextLine(); //limpia la introduccion de datos por consola
            aux = new CuerpoCeleste06();
            aux.setCodigoCuerpo(codigoCuerpo);
            aux.setNombre(nombre);
            aux.setdiametro(diametro);
            aux.setTipoObjeto(tipoObjeto);
            // Se agrega el cuerpo celeste al ArrayList
            planetas.add(aux);
            System.out.print("Quiere introducir un nuevo cuerpo celeste? ( S / N )");
            respuesta = sc.nextLine();
            if (respuesta.toUpperCase().equals("N")) {
                salir = true;
            }
        }

    }
}
