package clases;

import java.io.Serializable;
import java.util.Random;

public class Anden implements Serializable{
    private static final long serialVersionUID = 2L;

    private int id;
    private boolean ocupado;
    private Bus busAsignado;
    private int tiempoEnAnden;
    private static final Random rand = new Random(); 


    public Anden(int id) {
        this.id = id;
        this.ocupado = false;
    }

    public int getId(){
        return id;
    }

    public Bus getBusAsignado(){
        return busAsignado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void asignarBus(Bus bus) {
        this.busAsignado = bus;
        this.tiempoEnAnden = calcularTiempoEstadia();
        this.ocupado = true;
    }

    public void liberar() {
        this.busAsignado = null;
        this.ocupado = false;
    }

    public void decrementarTiempoEstadia() {
        if (tiempoEnAnden > 0) tiempoEnAnden--;
        if (tiempoEnAnden == 0) liberar();
    }

    public int calcularTiempoEstadia() {
        int tiempo = busAsignado.getTiempoEstadia();
        
        return rand.nextInt(5) + tiempo - 5;
        
    }
}
