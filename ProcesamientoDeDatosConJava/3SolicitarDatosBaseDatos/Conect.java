import java.sql.Connection;
import java.sql.DriverManager;

public class Conect {
	Connection con;
	public Conect(){
       try{
    	   //Registramos el driver JDBC
    	   Class.forName("com.mysql.jdbc.Driver");
    	   
    	  //Abrimos la conexion
    	   System.out.println("Conectando con la base de datos...");
    	   con = DriverManager.getConnection("jdbc:mysql://localhost/exercise06","root","password"); 
    	   
       }catch(Exception e){
    	   System.out.println("Error: " + e.getMessage());
       }
   }
}