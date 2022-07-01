package maestre.ordenadores.app;

import java.util.Scanner;
import maestre.ordenadores.modelo.Ordenador;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
public class Parte1app {
    public static void main(String[] args) throws Exception {
        try {
            // Creacion del array de ordenadores
            Ordenador[] ordenador = new Ordenador[6];
            ordenador[0]=new Portatil(24, 500, "port1", "Microsoft", "Surface", "2PROC", "SDD", 16, 4, true);
            ordenador[1]=new Portatil(24, 500, "port2", "Apple", "Pro", "2PROC", "SDD", 8, 8, true);
            ordenador[2]=new Portatil(11, 900, "port3", "MSI", "Aero", "3PROC", "SDD", 4, 2, false);
            ordenador[3]=new Sobremesa("PB01", "RTX 3090", "sobrem1", "Generico", "Model3", "PROC11", "SDD", 32, 8, true);
            ordenador[4]=new Sobremesa("PB02", "Intel HD 4000", "sobrem2", "HP", "HP5545", "PROC22", "HDD", 4, 4, false);
            ordenador[5]=new Sobremesa("PB03", "RTX 1660", "sobrem3", "Generico", "Model5", "PROC33", "HDD", 16, 8, false);
            // Inicio del programa
            System.out.println("---------- BIENVENIDO A LA SIMULACION DE ORDENADORES DE PROG09 ----------");
            for (Ordenador ord : ordenador) {
                System.out.println(ord.toString());
            }
            interfaz(ordenador);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Metodo que muestra los menus
     */
    private static void mostrarMenu(){
        System.out.println("Seleccione una de las opciones:");
        System.out.println("1. Listar todos los ordenadores mezclados portátiles y sobremesa");
        System.out.println("2. Listar sólo los portátiles");
        System.out.println("3. Listar sólo los ordenadores de sobremesa");
        System.out.println("4. Encender un ordenador");
        System.out.println("5. Apagar un ordenador");
        System.out.println("6. Dibujar un ordenador");
        System.out.println("7. Cargar Portátiles");
        System.out.println("8. Descargar Portátiles");
        System.out.println("9. Salir");
    }
    
    /**
     * Metodo para leer la entrada del teclado del usuario
     * @return lectura Numero que marca el usuario en el teclado
     */
    private static String leerTeclado() {
        String lectura = "";
        try {
            Scanner teclado = new Scanner(System.in);
            lectura = teclado.nextLine();
        } catch (Exception e) {
            System.err.println("Error: No se ha podido leer el teclado");
        }
        return lectura;
    }
    
    /**
     * Metodo para leer la entrada del teclado del usuario en forma de integer
     * @return opcion Numero que marca el usuario en el teclado
     */
    private static int leerOpcion() {
        int opcion = 0;
        opcion = Integer.parseInt(leerTeclado());
        return opcion;
    }
    
    /**
     * Metodo de la interfaz del programa
     * @param ordenador Array de ordenadores
     * @throws Exception
     */
    private static void interfaz(Ordenador[] ordenador) throws Exception {
        int opcion = 0;
        while (opcion != 10) {
            mostrarMenu();
            opcion = leerOpcion();
            if (opcion == 1) {
                for (Ordenador ord : ordenador) {
                    System.out.println(ord.toString());
                }
            }
            if (opcion == 2) {
                for (Ordenador ord : ordenador) {
                    if(ord instanceof Portatil){
                        System.out.println(ord.toString());
                    }
                }
            }
            if (opcion == 3) {
                for (Ordenador ord : ordenador) {
                    if(ord instanceof Sobremesa){
                        System.out.println(ord.toString());
                    }
                }
            }
            if (opcion == 4) {
                System.out.println("Introduzca la posicion del ordenador que quiere encender. Desde el 1 hasta el 6");
                opcion = leerOpcion();
                ordenador[opcion-1].arrancar();
            }
            if (opcion == 5) {
                System.out.println("Introduzca la posicion del ordenador que quiere apagar. Desde el 1 hasta el 6");
                opcion = leerOpcion();
                ordenador[opcion-1].apagar();
            }
            if (opcion == 6) {
                System.out.println("Introduzca la posicion del ordenador que quiere dibujar. Desde el 1 hasta el 6");
                opcion = leerOpcion();
                ordenador[opcion-1].dibujar();
            }
            if (opcion == 7) {
                System.out.println("Introduzca los minutos que quiere recargar todos los portatiles");
                opcion = leerOpcion();
                for (Ordenador ord : ordenador) {
                    if(ord instanceof Portatil portatil){
                        portatil.cargar(opcion);
                    }
                }
            }
            if (opcion == 8) {
                System.out.println("Introduzca los minutos que quiere descargar todos los portatiles");
                opcion = leerOpcion();
                for (Ordenador ord : ordenador) {
                    if(ord instanceof Portatil portatil){
                        portatil.descargar(opcion);
                    }
                }
            }
            if (opcion == 9) {
                System.err.println("Nelson Blanco Charro te agradece el uso de esta aplicacion");
                break;
            }
            System.out.println("");
        }
        
    }
}
