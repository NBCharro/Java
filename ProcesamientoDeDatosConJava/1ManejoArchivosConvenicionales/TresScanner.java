import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		Scanner entrada = new Scanner(System.in);		
		for(int i = 1; i < 6; i++) {
			System.out.println("Ingrese el numero " + i + " : ");
			String texto = entrada.next();
			int number = Integer.parseInt(texto);
			if (i == 1){
				num0 = number;
			}
			if (i == 2){
				num1 = number;
			}
			if (i == 3){
				num2 = number;
			}
			if (i == 4){
				num3 = number;
			}
			if (i == 5){
				num4 = number;
			}
		}
		entrada.close();
		System.out.println("La suma de los numeros es: " + suma(num0, num1, num2, num3, num4));
		System.out.println("La media de los numeros es: " + media(num0, num1, num2, num3, num4));
	}
	
	public static int suma(int n0, int n1, int n2, int n3, int n4){
		int sum = n0 + n1 + n2 + n3 + n4;
		return sum;
	}
	public static int media(int n0, int n1, int n2, int n3, int n4) {
		int med = (n0 + n1 + n2 + n3 + n4)/5;
		return med;
	}
}
