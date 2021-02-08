import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		File fichero = new File("/Users/nelsonmac/GitHub/JavaEclipse/Inem/Ejercicios/texto.txt");
		//Comprobamos que exista el archivo
		if(fichero.exists() == true) {
			contarpalabras(fichero);			
		}else {
			System.out.println("El fichero no existe");
		}
	}
	public static void contarpalabras(File fichero){
		
		try (Scanner sc = new Scanner(new FileInputStream(fichero))){
			//Establecemos el contador en 0
		    int palabras=0;
		    //Mientras que haya palabras por delante seguira en el While
		    while(sc.hasNext()){
		        sc.next();
		        palabras++;
		    }
		    //Printeamos la salida con el numero de palabras
		    System.out.println("Numero de palabras: " + palabras);
		    //Si algo sale mal, printeamos el error
			}catch(IOException e) {
			System.out.println("Error. No se han podido contar las palabras.");
			}
		}
	}