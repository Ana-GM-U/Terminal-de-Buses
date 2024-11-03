package clases;

import java.io.Serializable;

public class Bus implements Serializable{
    private static final long serialVersionUID = 3L;

    private int capacidad;
    private Personal chofer;
    private Personal ayudante; 
    private Personal segundoChofer;
    private String empresa; 
    private int tiempoEstadia;

    public Bus(int capacidad, Personal chofer, Personal ayudante) {
        this.capacidad = capacidad;
        this.chofer = chofer;
        this.ayudante = ayudante;
    }

    public Bus(int capacidad, Personal chofer, Personal ayudante, Personal segundoChofer) {
        this(capacidad, chofer, ayudante);
        this.segundoChofer = segundoChofer;
    }

    public void setTiempoEstadia(int tiempoEstadia) {
        this.tiempoEstadia = tiempoEstadia;
    }

    public int getTiempoEstadia() {
        return tiempoEstadia;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Personal getChofer() {
        return chofer;
    }

    public Personal getAyudante() {
        return ayudante;
    }

    public Personal getSegundoChofer() {
        return segundoChofer;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }
}
