/**
 *
 * @author Nelson Blanco Charro
 * @date 09/05/2022
 * @description Clase para realizar la conexion y modificacion de una base de datos Oracle
 */

package util;
import java.sql.*;

public class ConexionBD {
    private Connection conexion = null;
    /**
     * Contructor para establecer la conexión
     *
     * @param sgbd Base de datos
     * @param host Nombre del host
     * @param bd Nombre de la base de datos
     * @param usuario Usuario para la conexion
     * @param clave Clave del usuario
     */
    public ConexionBD(String sgbd, String host, String bd, String usuario, String clave) {
        setConexion(conectar(sgbd, host, bd, usuario, clave));
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Conectar métoco privado para establecer la conexión
     *
     * @param sgbd Base de datos
     * @param host Nombre del host
     * @param bd Nombre de la base de datos
     * @param usuario Usuario para la conexion
     * @param clave Clave del usuario
     * @return
     */
    private Connection conectar(String sgbd, String host, String bd, String usuario, String clave) {
        try {
            switch (sgbd.toLowerCase()) {
                case "mysql":
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, usuario, clave);
                    break;
                case "oracle":
                    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                    conexion = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":1521:" + bd, usuario, clave);
                    break;
            }
            System.out.println("Conexion Realizada");
            return conexion;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println("Error en la Conexión: " + e.getMessage());
            return null;
        }

    }

    /**
     * cerrar: cierra la conexión
     *
     */
    public void cerrar() {
        try {
            conexion.close();
            System.out.println("Conexion Cerrada");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * leerTodo: muestra todos los registros por consola
     * 
     * @throws SQLException
     *
     */
    public void leerTodo() throws SQLException {
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = "select * from APICULTURA";
        // Ejecuta una consulta que devuelve resultados                
        ResultSet rs = st.executeQuery(sql1);
        // Mostrar resultados
        while (rs.next()) {
            System.out.println(
                    "Id Colmena: " + rs.getString(1)
                    + " - Temporada Reina: " + rs.getString(2)
                    + " - Direccion: " + rs.getString(3)
                    + " - Kg de miel: " + rs.getString(4)
                    + " - Numero de alzas: " + rs.getString(5)
            );
        }
    }

    /**
     * leerUno: muestra un registro por consola
     * 
     * @param idColmena codigo para identificar la colmena para ver
     * 
     * @throws SQLException
     *
     */
    public void leerUno(Integer idColmena) throws SQLException {
        // Comprobamos que exista el ID
        if (!comprobarRegistro(idColmena)) {
            System.err.println("No existe el registro");
            //throw new Error("No existe el registro");
            return;
        }
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = "select * from APICULTURA WHERE ID_COLMENA= " + idColmena;
        // Ejecuta una consulta que devuelve resultados
        ResultSet rs = st.executeQuery(sql1);
        // Mostrar resultados
        while (rs.next()) {
            System.out.println(
                    "Id Colmena: " + rs.getString(1)
                    + " - Temporada Reina: " + rs.getString(2)
                    + " - Direccion: " + rs.getString(3)
                    + " - Kg de miel: " + rs.getString(4)
                    + " - Numero de alzas: " + rs.getString(5)
            );
        }
    }

    /**
     * insertarDato: inserta un nuevo registro en la base de datos. El ID se asigna automaticamente al numero mayor, se podria mejorar el metodo si se rellenase con los ID que fueron borrados.
     * 
     * @param reinaTemporada Año de nacimiento de la abeja reina
     * @param direccion Lugar donde esta el apiario de la colmena
     * @param kgMiel Kilogramos de miel producidos por la colmena
     * @param numeroAlzas Numero de alzas sobre la colmena
     * 
     * @throws SQLException
     *
     */
    public void insertarDato(Integer reinaTemporada, String direccion, Integer kgMiel, Integer numeroAlzas) throws SQLException {
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = "INSERT INTO APICULTURA VALUES ("
                + "(select max(ID_COLMENA)+1 from APICULTURA)"
                + ","
                + reinaTemporada + ","
                + "'" + direccion + "'" + ","
                + kgMiel + ","
                + numeroAlzas + ")";
        // Ejecuta una consulta que inserta los datos              
        ResultSet rs = st.executeQuery(sql1);
    }

    /**
     * eliminarDato: elimina el registro con el ID solicitado
     * 
     * @param idColmena ID del registro de la colmena
     * 
     * @throws SQLException
     *
     */
    public void eliminarDato(Integer idColmena) throws SQLException {
        // Comprobamos que exista el ID
        if (!comprobarRegistro(idColmena)) {
            System.err.println("No existe el registro");
            //throw new Error("No existe el registro");
            return;
        }
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = "DELETE FROM APICULTURA WHERE ID_COLMENA = " + idColmena;
        // Ejecuta una consulta que elimina el registro solicitado                
        ResultSet rs = st.executeQuery(sql1);
    }

    /**
     * modificarDato: modifica un registro
     * 
     * @param idColmena ID del registro de la colmena
     * @param reinaTemporada Año de nacimiento de la abeja reina
     * @param direccion Lugar donde esta el apiario de la colmena
     * @param kgMiel Kilogramos de miel producidos por la colmena
     * @param numeroAlzas Numero de alzas sobre la colmena
     * 
     * @throws SQLException
     *
     */
    public void modificarDato(Integer idColmena, Integer reinaTemporada, String direccion, Integer kgMiel, Integer numeroAlzas) throws SQLException {
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = "UPDATE APICULTURA SET "
                + "REINA_TEMPORADA=" + "" + reinaTemporada
                + ", DIRECCION_APIARIO=" + "'" + direccion + "'"
                + ", KG_MIEL=" + kgMiel
                + ", NUMERO_ALZAS=" + numeroAlzas
                + " WHERE ID_COLMENA=" + idColmena;
        // Ejecuta una consulta que modifica el registro              
        ResultSet rs = st.executeQuery(sql1);
    }

    /**
     * comprobarRegistro: comprueba que el ID existe en la base de datos
     * 
     * @param idColmena ID del registro de la colmena
     *
     * @return boolean Si existe el registro o no
     * 
     * @throws SQLException
     */
    public boolean comprobarRegistro(Integer idColmena) throws SQLException {
        // Creamos el Statement para poder hacer consultas
        Statement st = conexion.createStatement();
        // La consulta es un String con código SQL
        String sql1 = " select ID_COLMENA from APICULTURA WHERE ID_COLMENA= " + idColmena;
        // Ejecuta una consulta, si devuelve valor existe el ID, si devuelve vacio no existe el ID
        ResultSet rs = st.executeQuery(sql1);
        if (!rs.isBeforeFirst()) {
            return false;
        }
        return true;
    }

    /**
     * ejecutarConsulta: ejecuta la consulta SQL
     * 
     * @param sql Consulta SQL
     * 
     * @throws SQLException
     *
     */
    public ResultSet ejecutarConsulta(String sql) throws SQLException {
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(sql);
        return resultado;
    }
}
