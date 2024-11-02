package clases;

import java.util.List;
import java.util.ArrayList;

public class Compania {
    private String rut;
    private String nombre;
    private List<Viaje> viajes;
    private List<Bus> buses;

    public Compania(String rut, String nombre, List<Viaje> viajes) {
        this.rut = rut;
        this.nombre = nombre;
        this.viajes = viajes;
        this.buses = new ArrayList<>();
    }

    public String getNombre(String nombre){
        return this.nombre;
    }

    public List<Viaje> getViajes(){
        return this.viajes;
    }

    public void agregarBus(Bus bus) {
        buses.add(bus);
    }
}

