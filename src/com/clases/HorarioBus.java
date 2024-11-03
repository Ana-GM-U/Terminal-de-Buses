package clases;

import java.io.Serializable;


public class HorarioBus implements Serializable {
    private static final long serialVersionUID = 5L;

    private int hora;
    private Bus bus;
    private String origen;
    private String destino;

    public HorarioBus(int hora, Bus bus, String origen, String destino) {
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
    }

    public int getHora() {
        return hora;
    }

    public Bus getBus() {
        return bus;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setBus(Bus bus) {
         this.bus = bus;
    }
}

