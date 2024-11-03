package clases;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Terminal implements Serializable{
    private static final long serialVersionUID = 7L;

    private int horaApertura;
    private int horaCierre;
    private List<Anden> andenesLlegada;
    private List<Anden> andenesSalida;
    private List<Empresa> empresas;
    private Queue<Bus> colaEsperaLlegada;
    private Queue<Bus> colaEsperaSalida;

    public Terminal(int horaApertura, int horaCierre, int nAndenesLlegada, int mAndenesSalida) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    
        andenesLlegada = new ArrayList<>(nAndenesLlegada);
        for (int i = 1; i <= nAndenesLlegada; i++) {
            andenesLlegada.add(new Anden(i));
        }
        andenesSalida = new ArrayList<>(mAndenesSalida);
        for (int i = 1; i <= mAndenesSalida; i++) {
            andenesSalida.add(new Anden(i));
        }
        empresas = new ArrayList<>();
        colaEsperaLlegada = new LinkedList<>();
        colaEsperaSalida = new LinkedList<>();
    }

    public void agregarEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public int getHoraApertura(){
        return horaApertura;
    }

    public int getHoraCierre(){
        return horaCierre;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void asignarAndenLlegada(Bus bus) {
        for (Anden anden : andenesLlegada) {
            if (!anden.isOcupado()) {
                anden.asignarBus(bus);
                return;
            }
        }
        colaEsperaLlegada.add(bus);
    }

    public void asignarAndenSalida(Bus bus) {
        for (Anden anden : andenesSalida) {
            if (!anden.isOcupado()) {
                anden.asignarBus(bus);
                return;
            }
        }
        colaEsperaSalida.add(bus); 
    }

    public void avanzarTiempo() {
        for (Anden anden : andenesLlegada) {
            anden.decrementarTiempoEstadia(); 
            if (!anden.isOcupado() && !colaEsperaLlegada.isEmpty()) {
                Bus busEnEspera = colaEsperaLlegada.poll();
                anden.asignarBus(busEnEspera); 
            }
        }
    
        for (Anden anden : andenesSalida) {
            anden.decrementarTiempoEstadia();
            if (!anden.isOcupado() && !colaEsperaSalida.isEmpty()) {
                Bus busEnEspera = colaEsperaSalida.poll();
                anden.asignarBus(busEnEspera);
            }
        }
    }
    

    public void imprimirEstadoTerminal() {
        System.out.println("Estado del Terminal:");
        System.out.println("Andenes de Llegada:");
        for (Anden anden : andenesLlegada) {
            System.out.println("Andén " + anden.getId() + ": " + (anden.isOcupado() ? "Ocupado" : "Libre"));
        }
        System.out.println("Andenes de Salida:");
        for (Anden anden : andenesSalida) {
            System.out.println("Andén " + anden.getId() + ": " + (anden.isOcupado() ? "Ocupado" : "Libre"));
        }
        System.out.println("Cola de Espera de Llegada: " + colaEsperaLlegada.size() + " buses en espera.");
        System.out.println("Cola de Espera de Salida: " + colaEsperaSalida.size() + " buses en espera.");
    }
}
