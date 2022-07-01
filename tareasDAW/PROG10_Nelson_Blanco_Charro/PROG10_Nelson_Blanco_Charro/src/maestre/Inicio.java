/**
 *
 * @author Nelson Blanco Charro
 * @date 09/05/2022
 * @description Metodo Main para ver, insertar, eliminar y modificar registros en una base de datos Oracle
 */

package maestre;
import util.ConexionBD;
import java.sql.SQLException;
import java.util.Scanner;

public class Inicio {

    /**
     * main: metodo main
     *
     * @throws Exception
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException, Exception {
        // Los parametros son por orden: tipo de base de datos, nombre del host, nombre de la base de datos, usuario, clave
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");

        interfaz(conexion);

        conexion.cerrar();
    }

    /**
     * mostrarMenu: Metodo que muestra los menus
     * 
     */
    private static void mostrarMenu() {
        System.out.println("Seleccione una de las opciones:");
        System.out.println("1. Mostrar toda la base de datos");
        System.out.println("2. Ver un registro");
        System.out.println("3. Insertar nuevo registro");
        System.out.println("4. Eliminar registro");
        System.out.println("5. Modificar registro");
        System.out.println("6. Salir");
    }

    /**
     * leerTeclaso: Metodo para leer la entrada del teclado del usuario
     *
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
     * leerOpcion: Metodo para leer la entrada del teclado del usuario en forma de integer
     *
     * @return opcion Numero que marca el usuario en el teclado
     */
    private static int leerOpcion() {
        int opcion = 0;
        opcion = Integer.parseInt(leerTeclado());
        return opcion;
    }

    /**
     * interfaz: Metodo de la interfaz del programa
     *
     * @param ordenador Array de ordenadores
     * @throws Exception
     */
    private static void interfaz(ConexionBD conexion) throws Exception {
        int opcion = 0;
        while (opcion != 10) {
            mostrarMenu();
            opcion = leerOpcion();
            if (opcion == 1) {
                conexion.leerTodo();
            }
            if (opcion == 2) {
                System.out.println("Introduzca el ID de la colmena que quiere ver");
                Integer registro = Integer.parseInt(leerTeclado());
                conexion.leerUno(registro);
            }
            if (opcion == 3) {
                System.out.println("Introduzca la temporada de la reina");
                Integer reinaTemporada = Integer.parseInt(leerTeclado());
                System.out.println("Introduzca la direccion donde se encuentra la colmena");
                String direccionApiario = leerTeclado();
                System.out.println("Introduzca los Kg de miel producida");
                Integer kgMiel = Integer.parseInt(leerTeclado());
                System.out.println("Introduzca la cantidad de alzas que tiene");
                Integer numeroAlzas = Integer.parseInt(leerTeclado());
                conexion.insertarDato(reinaTemporada, direccionApiario, kgMiel, numeroAlzas);
            }
            if (opcion == 4) {
                System.out.println("Introduzca el ID de la colmena que quiere eliminar");
                Integer idColmena = Integer.parseInt(leerTeclado());
                conexion.eliminarDato(idColmena);
            }
            if (opcion == 5) {
                System.out.println("Introduzca el ID de la colmena que quiere modificar");
                Integer idColmena = Integer.parseInt(leerTeclado());
                if (!conexion.comprobarRegistro(idColmena)) {
                    System.err.println("No existe el registro");
                    //throw new Error("No existe el registro");
                } else {
                    System.out.println("Introduzca la temporada de la reina");
                    Integer reinaTemporada = Integer.parseInt(leerTeclado());
                    System.out.println("Introduzca la direccion donde se encuentra la colmena");
                    String direccionApiario = leerTeclado();
                    System.out.println("Introduzca los Kg de miel producida");
                    Integer kgMiel = Integer.parseInt(leerTeclado());
                    System.out.println("Introduzca la cantidad de alzas que tiene");
                    Integer numeroAlzas = Integer.parseInt(leerTeclado());
                    conexion.modificarDato(idColmena, reinaTemporada, direccionApiario, kgMiel, numeroAlzas);
                }
            }
            if (opcion == 6) {
                System.err.println("Nelson Blanco Charro te agradece el uso de esta base de datos de apicultura");
                break;
            }
            System.out.println("");
        }
    }
}
