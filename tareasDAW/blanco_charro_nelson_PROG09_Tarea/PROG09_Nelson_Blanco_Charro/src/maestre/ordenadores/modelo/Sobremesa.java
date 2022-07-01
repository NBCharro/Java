package maestre.ordenadores.modelo;

import maestre.general.interfaces.Reparable;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
public class Sobremesa extends Ordenador implements Reparable{
    
    /**
     * @attribute placaBase Codigo de la placa base
     * @attribute tarjetaGrafica Nombre de la tarjeta grafica
     */
    private String placaBase;
    private String tarjetaGrafica;
    
    /**
     * Constructor por defecto
     */
    public Sobremesa() {
        this.placaBase = "PB123";
        this.tarjetaGrafica = "RTX3090";
    }
    
    /**
     * Constructor por parametros
     * @throws Exception
     */
    public Sobremesa(String placaBase, String tarjetaGrafica, String numeroSerie, String marca, String modelo, String procesador, String tipoDiscoDuro, int memoriaRAM, int nucleos, boolean arrancado) throws Exception {
        super(numeroSerie, marca, modelo, procesador, tipoDiscoDuro, memoriaRAM, nucleos, arrancado);
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }
    
    /**
     * Metodo que sobrescribe el toString de Ordenadores para agregar los nuevos atributos.
     * @return
     */
    @Override
    public String toString(){
        String frase = super.toString()+
                " -Placa base: " + this.placaBase +
                " -Tarjeta grafica: " + this.tarjetaGrafica;
        return frase;
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
    
// Getter y Setter
    public String getPlacaBase() {
        return placaBase;
    }
    
    public void setPlacaBase(String placaBase) {
        this.placaBase = placaBase;
    }
    
    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }
    
    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }
    
// Interfaces
    /**
     * Metodo de la interfaz Reparable
     */
    @Override
    public void reparar() {
        System.out.println("******** El ordenador de sobremesa se esta reparando ********");
    }
}
