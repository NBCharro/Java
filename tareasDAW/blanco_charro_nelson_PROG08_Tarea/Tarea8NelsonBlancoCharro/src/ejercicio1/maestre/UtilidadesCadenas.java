package ejercicio1.maestre;

/**
 * Clase UtilidadesCadenas
 *
 * @author Nelson Blanco Charro
 * @date 16/03/2022
 */
public class UtilidadesCadenas {

    /*
    * Metodo que une dos cadenas
    * @param cadena1 Cadena de texto que se unira en la primera posicion
    * @param cadena2 Cadena de texto que se unira en la segunda posicion
    * @return cadenaCompleta Union de las cadenas de texto
     */
    public static String unionCadenas(String cadena1, String cadena2) {
        // No sabia si habia solo hay que unir las cadenas o habria que comprobar si existen espacios entre ellas
        // He verificado que exista el espacio entre las cadenas, comprobando que no haya 2 espacios
        // Al final del metodo esta comentado el return en el caso de que no fuese necesaria la comprobacion
        String cadenaCompleta;
        if (cadena1.endsWith(" ") && cadena2.startsWith(" ")) {
            cadenaCompleta = cadena1 + cadena2.substring(1);
        } else if (cadena1.endsWith(" ") || cadena2.startsWith(" ")) {
            cadenaCompleta = cadena1 + cadena2;
        } else {
            cadenaCompleta = cadena1 + " " + cadena2;
        }
        return cadenaCompleta;
        // return cadena1 + cadena2;
    }

    // Reciba una cadena y una letra, y devuelva cuántas veces está dicha letra en la cadena.
    /*
    * Metodo que recibe una cadena y una letra y comprueba la cantidad de veces que esta la letra en la cadena
    * @param cadena Cadena de texto
    * @param letra Caracter para contar la cantidad de veces que aparece en la cadena
    * @return contador Numero de veces que aparece la letra en la cadena de texto
     */
    public static int cantidadChar(String cadena, char letra) {
        int posicion, contador = 0;
        posicion = cadena.indexOf(letra);
        while (posicion != -1) {
            contador++;
            posicion = cadena.indexOf(letra, posicion + 1);
        }
        return contador;
    }

    /*
    * Metodo que comprueba si una cadena de texto es palindroma
    * @param cadena Cadena de texto para comprobar
    * @return boolean Indica si es o no es palindroma
     */
    public static boolean esPalindroma(String cadena) {
        String fraseGirada = girarFrase(cadena);
        return cadena.toUpperCase().equalsIgnoreCase(fraseGirada);
    }

    /*
    * Metodo para darle la vuelta a una cadena de texto
    * @param cadena Cadena de texto para darle la vuelta
    * @return String Cadena de texto girada
     */
    public static String girarFrase(String cadena) {
        StringBuilder inverso = new StringBuilder(cadena);
        return inverso.reverse().toString();
    }
}
