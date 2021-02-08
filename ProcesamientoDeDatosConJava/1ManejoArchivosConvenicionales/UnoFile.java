import java.io.File;

	public class Main {

		public static void main(String[] args){
			
			// Utilizamos File para buscar el archivo
			File imagen = new File("C:/Ejercicios/java.png");
			
			//Utilizamos .exists() para ver si existe o no el archivo buscado
			if(imagen.exists() == true) {
				System.out.println("El fichero existe");			
			}else {
				System.out.println("El fichero no existe");
			}
		}
	}