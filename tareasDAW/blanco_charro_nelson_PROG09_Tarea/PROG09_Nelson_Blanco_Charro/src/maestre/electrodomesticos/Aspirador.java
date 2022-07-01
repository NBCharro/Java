package maestre.electrodomesticos;

import maestre.general.interfaces.Reparable;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
public class Aspirador implements Reparable{
    /**
     * @attribute nombre Nombre del aspirador
     * @attribute modelo Modelo del aspirador
     * @attribute voltaje Voltaje del aspirador
    */
    private String nombre;
    private String modelo;
    private int voltaje;
    
    /**
     * Constructor por defecto
     */
    public Aspirador() {
        this.nombre = "Bosh";
        this.modelo = "BCH3P210";
        this.voltaje = 22;
    }
    
    /**
     * Metodo de la interfaz Reparable
     */
    @Override
    public void reparar() {
        System.out.println("----- El aspirador esta en reparacion -----");
    }
    
}
