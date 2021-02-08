import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Opcion1 option1 = new Opcion1();
		Opcion2 option2 = new Opcion2();
		Opcion3 option3 = new Opcion3();
		
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		
		while (numero != 1567) {
			System.out.println("Seleccione una opcion:");
			System.out.println();
			System.out.println("1. Opcion 1: Lista de paises.");
			System.out.println("2. Opcion 2: Paises que tienen el Euro como moneda");
			System.out.println("3. Opcion 3: Paises con superficie mayor de 1.000.000");
			System.out.println("4. Opcion 4: Salir.");
			System.out.println();
			numero = sc.nextInt();
			if(numero == 1) {
				System.out.println("Lista de paises:");
				System.out.println();
				option1.paises();
			}
			if(numero == 2) {
				System.out.println("Paises que tienen el Euro como moneda:");
				System.out.println();
				option2.euro();
			}
			if(numero == 3) {
				System.out.println("Paises con superficie mayor de 1.000.000:");
				System.out.println();
				option3.superficie();
			}
			if(numero == 4) {
				System.out.println();
				System.out.println("Gracias por usar nuestros servicios.");
				break;
			}
		}
		
	}

}

