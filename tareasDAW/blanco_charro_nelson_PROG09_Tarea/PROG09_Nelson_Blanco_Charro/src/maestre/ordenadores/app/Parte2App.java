package maestre.ordenadores.app;

import java.util.Arrays; 
import maestre.electrodomesticos.Aspirador;
import maestre.general.interfaces.Reparable;
import maestre.ordenadores.modelo.Portatil;
import maestre.ordenadores.modelo.Sobremesa;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
public class Parte2App {
    public static void main(String[] args) throws Exception{
        Reparable[] reparables = new Reparable[6];
        reparables[0]=new Portatil();
        reparables[1]=new Portatil();
        reparables[2]=new Sobremesa();
        reparables[3]=new Sobremesa();
        reparables[4]=new Aspirador();
        reparables[5]=new Aspirador();
        reparaTodo(reparables);
        
// Ejercicio 4
        Portatil[] ordenador = new Portatil[3];
        ordenador[0]=new Portatil(13, 500, "port1", "Microsoft", "Surface", "2PROC", "SDD", 16, 4, true);
        ordenador[1]=new Portatil(15, 500, "port2", "Apple", "Pro", "2PROC", "SDD", 8, 8, true);
        ordenador[2]=new Portatil(23, 900, "port3", "MSI", "Aero", "3PROC", "SDD", 4, 2, false);
        System.out.println("");
        System.out.println("Array de portatiles desordenado");
        for (Portatil portatil : ordenador) {
            System.out.println(portatil.toString());
        }
        System.out.println("");
        System.out.println("Array de portatiles ordenado");
        Arrays.sort(ordenador);
        for (Portatil portatil : ordenador) {
            System.out.println(portatil.toString());
        }
    }
    
    // Lista de objetos que implementan la infertaz Reparable.
    // La verdad es que es super util, supongo que sobretodo en tests.
    static void reparaTodo(Reparable cosas[]){
        for (Reparable cosa : cosas) {
            cosa.reparar();
        }
    }
}
