import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Opcion3 {
	public void superficie() {
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://IP:PORT/geografia?useSSL=false";
		// Database credentials
		String USER = "root";
		String PASS = "password";
		Connection conn = null;
		Statement stmt = null;
		try {
			// PASO 1: Registrar el driver JDBC
			Class.forName(JDBC_DRIVER);
			// PASO 2: Abrir conexi�n
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// PASO 3: Ejecutar consulta
			stmt = conn.createStatement();
			String sql = "SELECT * FROM paises";

			ResultSet rs = stmt.executeQuery(sql);
			// PASO 4: Extraer datos del ResultSet
			while (rs.next()) {
				if (rs.getInt("superficie") > 1000000) {
					System.out.println(rs.getString("nombre") + 
							" con una superficie de: " +  rs.getString("superficie"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// PASO 5: Cerrar conexiones
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
