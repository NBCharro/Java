/**
 *
 * @author Nelson Blanco Charro
 * @date 10/05/2022
 * @description Clase con metodos estaticos para realizar las llamadas a la base
 * de datos
 */
package util;

import java.sql.SQLException;

public class Operaciones {

    /**
     * insertarBD: inserta un registro en la base de datos
     *
     * @param reinaTemporada Año de nacimiento de la abeja reina
     * @param direccionApiario Lugar donde esta el apiario de la colmena
     * @param kgMiel Kilogramos de miel producidos por la colmena
     * @param numeroAlzas Numero de alzas sobre la colmena
     *
     * @throws SQLException
     *
     */
    public static void insertarBD(int reinaTemporada, String direccionApiario, int kgMiel, int numeroAlzas)
            throws SQLException {
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        conexion.insertarDato(reinaTemporada, direccionApiario, kgMiel, numeroAlzas);
        conexion.cerrar();
    }

    /**
     * buscarBD: inserta un registro en la base de datos
     *
     * @param idColmena codigo para identificar la colmena
     *
     * @return resultado Array con los valores de la columna del registro
     *
     * @throws SQLException
     *
     */
    public static String[] buscarBD(int idColmena) throws SQLException {
        String[] resultado = new String[4];
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        resultado = conexion.leerUno(idColmena);
        conexion.cerrar();
        return resultado;
    }

    /**
     * modificarBD: busca un registro en la base de datos
     *
     * @param idColmena Codigo para identificar la colmena
     * @param reinaTemporada Año de nacimiento de la abeja reina
     * @param direccionApiario Lugar donde esta el apiario de la colmena
     * @param kgMiel Kilogramos de miel producidos por la colmena
     * @param numeroAlzas Numero de alzas sobre la colmena
     *
     * @throws SQLException
     *
     */
    public static void modificarBD(int idColmena, int reinaTemporada, String direccionApiario, int kgMiel,
            int numeroAlzas) throws SQLException {
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        if (!conexion.comprobarRegistro(idColmena)) {
            throw new Error("No existe el registro");
        } else {
            conexion.modificarDato(idColmena, reinaTemporada, direccionApiario, kgMiel, numeroAlzas);
        }
        conexion.cerrar();
    }

    /**
     * eliminarBD: elimina un registro de la base de datos
     *
     * @param idColmena codigo para identificar la colmena
     *
     * @throws SQLException
     *
     */
    public static void eliminarBD(int idColmena) throws SQLException {
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        conexion.eliminarDato(idColmena);
        conexion.cerrar();
    }

    /**
     * totalMielBD: obtiene el total de miel producido por las colmenas
     *
     * @return total Cantidad total de miel
     * 
     * @throws SQLException
     *
     */
    public static int totalMielBD() throws SQLException {
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        Integer total = conexion.totalMiel();
        conexion.cerrar();
        return total;
    }

    /**
     * numAlzasBD: obtiene la media de alzas por colmena
     *
     * @return media Cantidad media de alzas por colmena
     * @throws SQLException
     *
     */
    public static int numAlzasBD() throws SQLException {
        ConexionBD conexion = new ConexionBD("oracle", "localhost", "XE", "SYSTEM", "123456");
        Integer media = conexion.numAlzas();
        conexion.cerrar();
        return media;
    }
}
