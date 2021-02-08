
public class Main {

	public static void main(String[] args){
		File fichero = new File("C:/Ejercicios/texto.txt");
		contarpalabras(fichero);		
	}
	public static void contarpalabras(File fichero){
		
		try (Scanner sc = new Scanner(new FileInputStream(fichero))){
			int palabras=0;
		    while(sc.hasNext()){
		        sc.next();
		        palabras++;
		    };
		    System.out.println("Numero de palabras: " + palabras);		    
		    //Modificacion del Error con GetMessage
			}catch (Exception e) {
				System.out.println("Ha surgido un error:" + "\n" + e.getMessage());
			}
		}
	}