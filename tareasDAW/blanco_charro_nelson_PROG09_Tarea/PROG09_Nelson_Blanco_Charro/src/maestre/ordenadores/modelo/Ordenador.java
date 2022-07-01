package maestre.ordenadores.modelo;

/**
 *
 * @author Nelson Blanco Charro
 * @date 4/4/2022
 */
abstract public class Ordenador {
    /**
     * @attribute numeroSerie Numero de serie del ordenador. Maximo 20 caracteres
     * @attribute marca Marca del ordenador
     * @attribute modelo Modelo del ordenador
     * @attribute procesador Nombre del procesador
     * @attribute tipoDiscoDuro Tipo de disco duro SDD o HDD
     * @attribute memoriaRAM Valor de la RAM. Maximo 3 digitos
     * @attribute nucleos Numero de nucleos. Maximo 2 digitos
     * @attribute arrancado Indica si el ordenador esta encendido o no
     */
    protected String numeroSerie;
    protected String marca;
    protected String modelo;
    protected String procesador;
    protected String tipoDiscoDuro;
    protected int memoriaRAM;
    protected int nucleos;
    protected boolean arrancado;
    
    /**
     * Constructor por defecto
     */
    public Ordenador() {
        this.numeroSerie = "25B25";
        this.marca="HP";
        this.modelo="Mod456";
        this.procesador="Proc123";
        this.tipoDiscoDuro = "SSD";
        this.memoriaRAM=8;
        this.nucleos=4;
        this.arrancado = false;
    }
    
    /**
     * Constructor con parametros
     */
    public Ordenador(String numeroSerie, String marca, String modelo, String procesador, String tipoDiscoDuro, int memoriaRAM, int nucleos, boolean arrancado) throws Exception {
        setNumeroSerie(numeroSerie);
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        setTipoDiscoDuro(tipoDiscoDuro);
        setMemoriaRAM(memoriaRAM);
        setNucleos(nucleos);
        this.arrancado = arrancado;
    }
    
// Metodos
    /**
     * Metodo para encender el ordenador. Tiene una ligera animacion de encendido.
     * @throws Exception
     */
    public void arrancar() throws Exception{
        try {
            if(this.arrancado){
                System.out.println("El ordenador estaba encendido.");
            }else{
                System.out.println("El ordenador se esta arrancando...");
                // Simulamos un arranque de 3 segundos
                Thread.sleep(1*1000);
                System.out.println(".");
                Thread.sleep(1*1000);
                System.out.println("..");
                Thread.sleep(1*1000);
                System.out.println("...");
                Thread.sleep(1*1000);
                this.arrancado = true;
                System.out.println("El ordenador esta arrancado");
            }
        } catch (InterruptedException e) {
            throw new Exception("Error en el arrancado");
        }
    }
    
    /**
     * Metodo para apagar el ordenador. Tiene una ligera animacion de apagado.
     * @throws Exception
     */
    public void apagar() throws Exception{
        try {
            if(!this.arrancado){
                System.out.println("El ordenador estaba apagando.");
            }else{
                System.out.println("El ordenador se esta apagando...");
                // Simulamos un arranque de 3 segundos
                Thread.sleep(1*1000);
                System.out.println(".");
                Thread.sleep(1*1000);
                System.out.println("..");
                Thread.sleep(1*1000);
                System.out.println("...");
                Thread.sleep(1*1000);
                this.arrancado = false;
                System.out.println("El ordenador esta apagado");
            }
        } catch (InterruptedException e) {
            throw new Exception("Error en el arrancado");
        }
    }
    
    /**
     * Metodo abstracto para dibujar
     */
    abstract public void dibujar();
    
// Metodos que sobreescriben
    /**
     * Metodo que sobrescribe toString
     * @return frase Componentes del objeto
     */
    @Override
    public String toString(){
        
        String frase =
                "Numero de serie: " + this.numeroSerie +
                " -Marca: " + this.marca +
                " -Modelo: " + this.modelo +
                " -Procesador: " + this.procesador +
                " -Disco duro: " + this.tipoDiscoDuro +
                " -Memoria RAM: " + this.memoriaRAM +
                " -Nucleos: " + this.nucleos +
                " -Arrancado: " + this.arrancado;
        return frase;
    }
    
    /**
     * Metodo que sobrescribe a equals para comparar numeros de serie
     * @param obj Objeto que se compara
     * @return res True o False
     */
    @Override
    public boolean equals(Object obj){
        // Compruebo si lo que se ha pasado “es un” objeto ordenador.
        if (obj != null && !(obj instanceof Ordenador)){
            return false;
        }
        boolean res = false;
        Ordenador otro = (Ordenador)obj;
        if (this.numeroSerie.equals(otro.numeroSerie)){
            res = true;
        }
        return res;
    }
    
// Getter y Setter
    public String getNumeroSerie() {
        return numeroSerie;
    }
    // Metodo set que comprueba que la longitud sea menor a 20
    public void setNumeroSerie(String numeroSerie) throws Exception {
        if(numeroSerie.length() <= 20){
            this.numeroSerie = numeroSerie;
        } else{
            throw new Exception("El numero de serie tiene que tener maximo 20 caracteres");
        }
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getProcesador() {
        return procesador;
    }
    
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
    public String getTipoDiscoDuro() {
        return tipoDiscoDuro;
    }
    // Metodo set que verifica que el disco duro es HDD o SDD
    public void setTipoDiscoDuro(String tipoDiscoDuro) throws Exception {
        if(tipoDiscoDuro.equals("HDD") || tipoDiscoDuro.equals("SDD")){
            this.tipoDiscoDuro = tipoDiscoDuro;
        }else{
            throw new Exception("El disco duro tiene que ser HDD o SDD");
        }
    }
    
    public int getMemoriaRAM() {
        return memoriaRAM;
    }
    // Metodo set que verifica que la memoria RAM es menor de 3 digitos
    public void setMemoriaRAM(int memoriaRAM) throws Exception {
        String maximo = Integer.toString(memoriaRAM);
        if(maximo.length()<=3){
            this.memoriaRAM = memoriaRAM;
        }else{
            throw new Exception("La RAM debe ser menor o igual de 999 GB");
        }
    }
    
    public int getNucleos() {
        return nucleos;
    }
    // Metodo set que verifica que los nucleos son menores a 2 digitos
    public void setNucleos(int nucleos) throws Exception {
        String maximo = Integer.toString(nucleos);
        if(maximo.length()<=3){
            this.nucleos = nucleos;
        }else{
            throw new Exception("Los nucleos deben ser menores o iguales de 99 GB");
        }
    }
    
    public boolean isArrancado() {
        return arrancado;
    }
    
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }
    
}
