package clases;

public class Bus {
    private String patente;
    private Viaje viaje;
    private Ayudante ayudante;
    private Chofer chofer1;
    private Chofer chofer2;
    private Tipo tipo;

    public Bus(String patente, Viaje viaje, Ayudante ayudante, Chofer chofer1) {
        this.patente = patente;
        this.viaje = viaje;
        this.ayudante = ayudante;
        this.chofer1 = chofer1;
    }

    public Bus(String patente, Viaje viaje, Ayudante ayudante, Chofer chofer1, Chofer chofer2){
        this.patente = patente;
        this.viaje = viaje;
        this.ayudante = ayudante;
        this.chofer1 = chofer1;
        this.chofer2 = chofer2;
    }

    public String getPatente() {
        return patente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public Ayudante getAyudante(){
        return this.ayudante;
    }
    
    public Chofer getChofer1(){
        return this.chofer1;
    }
    
    public Chofer getChofer2(){
        return this.chofer2;
    }

    public Tipo getTipo(){
        return this.tipo;
    }
}

