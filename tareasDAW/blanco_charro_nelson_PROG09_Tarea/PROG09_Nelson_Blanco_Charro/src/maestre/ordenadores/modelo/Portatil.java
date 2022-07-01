package maestre.ordenadores.modelo;

import maestre.general.interfaces.Reparable;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
public class Portatil extends Ordenador implements Reparable, java.lang.Comparable<Portatil>{
    
    /**
     * @attribute pulgadas Numero de pulgadas de la pantalla. Maximo 2 digitos.
     * @attribute duracionBateria Duracion de la bateria del portatil
     */
    private int pulgadas;
    private int duracionBateria;
    
    /**
     * Constructor por defecto
     */
    public Portatil() {
        this.pulgadas = 25;
        this.duracionBateria = 300;
    }
    
    /**
     * Constructor por parametros
     * @throws Exception
     */
    public Portatil(int pulgadas, int duracionBateria, String numeroSerie, String marca, String modelo, String procesador, String tipoDiscoDuro, int memoriaRAM, int nucleos, boolean arrancado) throws Exception {
        super(numeroSerie, marca, modelo, procesador, tipoDiscoDuro, memoriaRAM, nucleos, arrancado);
        setPulgadas(pulgadas);
        this.duracionBateria = duracionBateria;
    }
    
    
// Metodos
    /**
     * Metodo para cargar la bateria del portatil
     * @param cantidad Numero de minutos que se sumaran a la bateria
     * @throws Exception
     */
    public void cargar(int cantidad) throws Exception{
        if(cantidad > 0){
            this.duracionBateria = this.duracionBateria + cantidad;
        } else if(cantidad == 0){
            System.out.println("No ha agregado duracion a la bateria");
        } else{
            throw new Exception("Ha introducido un valor negativo o incorrecto.");
        }
    }
    
    /**
     * Metodo para descargar la bateria del portatil
     * @param cantidad Numero de minutos que se restaran a la bateria
     * @throws Exception
     */
    public void descargar(int cantidad) throws Exception{
        int bateria = this.duracionBateria - cantidad;
        if(bateria <= 0 && cantidad > 0){
            this.duracionBateria = 0;
        }else if(bateria >= 0 && cantidad > 0){
            this.duracionBateria = bateria;
        }else{
            throw new Exception("Ha introducido un valor negativo o incorrecto.");
        }
    }
    
    /**
     * Metodo abstracto que hace un dibujo con nucleos y memoria RAM
     */
    @Override
    public void dibujar() {
        if(this.arrancado){
            System.out.println(toString());
            for (int i = 0; i < this.nucleos; i++) {
                for (int j = 0; j < this.memoriaRAM; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }}else{
            System.out.println("El ordenador esta apagado. Enciendalo primero para dibujarlo.");
        }
    }
    
    /**
     * Metodo que sobrescribe el toString de Ordenadores para agregar los nuevos atributos.
     * @return
     */
    @Override
    public String toString(){
        String frase = super.toString()+
                " -Pulgadas: " + this.pulgadas +
                " -Duracion de bateria: " + this.duracionBateria;
        return frase;
    }
    
// Getter y Setter
    public int getPulgadas() {
        return pulgadas;
    }
    // Metodo set que verifica que las pulgadas son menores a 2 digitos
    public void setPulgadas(int pulgadas) throws Exception {
        String maximo = Integer.toString(pulgadas);
        if(maximo.length()<=3){
            this.pulgadas = pulgadas;
        }else{
            throw new Exception("Los nucleos deben ser menores o iguales de 99 GB");
        }
    }
    
    public int getDuracionBateria() {
        return duracionBateria;
    }
    
    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }
    
// Interfaces
    /**
     * Metodo de la interfaz Reparable
     */
    @Override
    public void reparar() {
        System.out.println("******** El portatil se esta reparando ********");
    }
    
    /**
     * Metodo para rdenar los arrays del objeto mediante la API de Java
     * @param otroPor Objeto Portatil para comparar
     * @return
     */
    public int compareTo(Portatil otroPor) {
        int este = this.pulgadas;
        int otro = otroPor.pulgadas;
        if (este == otro){
            return 0;
        }
        else if (este < otro){
            return otro - este;
        }
        else {
            return este - otro;
        }
    }
}