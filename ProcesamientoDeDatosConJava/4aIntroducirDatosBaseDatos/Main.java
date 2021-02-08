import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		// JDBC nombre del driver y de la URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// Agregar "?useSSL=false" al final del nombre de la base de datos para evitar el warning: "WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification."
		String DB_URL = "jdbc:mysql://IP:PORT/geografia?useSSL=false";

		// Credenciales
		String USER = "root";
		String PASS = "password";
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			//Registrar el driver JDBC
			Class.forName(JDBC_DRIVER).newInstance(); 
			//Abrimos la conexion
	        con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			System.out.println("Preparando la introduccion de datos");
			//Preparamos la sentencia INSERT. No definimos los valores de la sentencia, las interrogaciones seran sustituidas mas adelante.
			stmt = con.prepareStatement("INSERT INTO paises VALUES (?,?,?,?,?,?)");
			//Generamos las variables con los datos a insertar. Se pueden introducir por un Scanner por ejemplo.
			String snombre = "Jamaica";
			String ssistema = "monarquía";
			int ssuperficie = 10991;
			String smoneda = "dólar jamaicano";
			String smonedaantigua = null;
			String sidioma = "inglés";
			//Introducimos los cambios para cada columna en la nueva fila
			((PreparedStatement) stmt).setString(1,snombre);
			((PreparedStatement) stmt).setString(2,ssistema);
			((PreparedStatement) stmt).setInt(3,ssuperficie);
			((PreparedStatement) stmt).setString(4,smoneda);
			((PreparedStatement) stmt).setString(5,smonedaantigua);
			((PreparedStatement) stmt).setString(6,sidioma);
			//Actualizamos la base de datos
			int retorno = stmt.executeUpdate();
			//Si retorno es un 1 es que se ha introducido correctamente la actualizacion, si es un 0 es que ha habido un fallo
	        if (retorno>0)
	           System.out.println("Insertado correctamente"); 
	        
	        //Ejecutamos la consulta de la base de datos
	        String sql = "SELECT * FROM paises";
			ResultSet rs = stmt.executeQuery(sql);

			// Extraermos los datos de cada fila de la base de datos y la printeamos con un While
			while (rs.next()) {
				System.out.print("Nombre: " + rs.getString("nombre"));
				System.out.print(", Sistema: " + rs.getString("sistema"));
				System.out.print(", Superficie: " + rs.getInt("superficie"));
				System.out.print(", Moneda: " + rs.getString("moneda"));
				System.out.print(", Moneda Antigua: " + rs.getString("monedaantigua"));
				System.out.println(", Idioma: " + rs.getString("idioma"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrarmos las conexiones
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin de ejecucion!");
	}
}