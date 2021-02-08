import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		 Conect conexion = new Conect();
		 Statement st;
		 ResultSet rs;
		 try {
			 //Ejecutamos la consulta
			 st = conexion.con.createStatement();
			 //Seleccionamos todas(*) las columnas de la base de datos (empleados)
			 rs=st.executeQuery("select * from empleados");
			 //Printeamos resultados en ciclo while por cada fila que haya
			 while(rs.next()) {
				 System.out.println(rs.getInt("id") + " " + rs.getString("first") + " " + rs.getString("last") + " " + rs.getInt("age"));
			 }
			 //Cerramos conexion
			 conexion.con.close();
		//Capturamos excepciones
		 }catch(Exception e) {
			 System.out.println("Error general: " + e.getMessage());
		 }
	   }
	}