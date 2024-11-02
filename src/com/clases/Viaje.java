package clases;

public class Viaje {
    private int tiempo;
    private String origen;
    private String destino;

    public Viaje(int tiempo, String origen, String destino) {
        this.tiempo = tiempo;
        this.origen = origen;
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
