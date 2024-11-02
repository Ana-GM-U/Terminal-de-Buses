package clases;

import funciones.ConversorHoras;
import java.util.List;
import java.util.Random;

public class Administrador {
    Terminal terminal;

    public Administrador(Terminal terminal) {
        this.terminal = terminal;
    }

    public void asignarBussLlegada(Bus bus) {
        List<Anden> andenes = this.terminal.getAndenesLLegada();
        boolean asignado = false;
        for(int l = 0; l<andenes.size(); l++) {
            if(andenes.get(l).getOcupado() == false){
                andenes.get(l).ocupar(bus);
                asignado = true;
            }
        }
        if(asignado == false){
            this.terminal.agregarBusLlegada(bus);
        }

        return;
    }

    public void asignarBusSalida(Bus bus) {
        List<Anden> andenes = this.terminal.getAndenesSalida();
        boolean asignado = false;
        for(int l = 0; l<andenes.size(); l++) {
            if(andenes.get(l).getOcupado() == false){
                andenes.get(l).ocupar(bus);
                asignado = true;
            }
        }
        if(asignado == false){
            this.terminal.agregarBusSalida(bus);
        }

        return;
    }

    public void asignarTiempoAnden(Bus bus) {
        Random random = new Random();
        int tiempoSegundos = 600 + random.nextInt(601);
        bus.getViaje().setTiempo(tiempoSegundos); // Asigna el tiempo de viaje al bus
    } 
}
