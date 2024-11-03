package clases;

import java.io.Serializable;
import funciones.ConversorHoras;

public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String rut;
    private String contrasena;
    private int tiempoBusChico;
    private int tiempoBusMedio;
    private int tiempoBusGrande;

    public Administrador(String nombre, String rut, String contrasena) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public Terminal crearTerminal(String horaApertura, String horaCierre, int numAndenesLlegada, int numAndenesSalida) {
        int horaAbre = ConversorHoras.convertirHoraAMinutos(horaApertura);
        int horaCierra = ConversorHoras.convertirHoraAMinutos(horaCierre);
        return new Terminal(horaAbre, horaCierra, numAndenesLlegada, numAndenesSalida);
    }

    public void asignarTiempoABusPorCapacidad(int tiempoBusChico, int tiempoBusMedio, int tiempoBusGrande){
        this.tiempoBusChico = tiempoBusChico;
        this.tiempoBusMedio = tiempoBusMedio;
        this.tiempoBusGrande = tiempoBusGrande;
    }

    public void asignarTiempoEnAnden(Bus bus) {
        int capacidad = bus.getCapacidad();
        int tiempoEstadia;

        if (capacidad < 30) {
            tiempoEstadia = tiempoBusChico; 
        } else if (capacidad < 50) {
            tiempoEstadia = tiempoBusMedio; 
        } else {
            tiempoEstadia = tiempoBusGrande;
        }

        bus.setTiempoEstadia(tiempoEstadia);
    }

    public void consultarInformacion(HorarioBus horario) {
        System.out.println("Información del Bus:");
        System.out.println("Origen: " + horario.getOrigen());
        System.out.println("Destino: " + horario.getDestino());
        System.out.println("Capacidad: " + horario.getBus().getCapacidad());
        System.out.println("Chofer: " + horario.getBus().getChofer());
        System.out.println("Ayudante: " + horario.getBus().getAyudante());
        
        if (horario.getBus().getSegundoChofer() != null) {
            System.out.println("Segundo Chofer: " + horario.getBus().getSegundoChofer());
        }
        
        System.out.println("Compañía: " + horario.getBus().getEmpresa());
        System.out.println("Tiempo de Estadía: " + horario.getBus().getTiempoEstadia() + " minutos");
    }

    public void agregarHorarioLlegada(Empresa empresa, String horaLlegada, Bus bus, String origen, String destino) {
        int minutosLlegada = ConversorHoras.convertirHoraAMinutos(horaLlegada);
        asignarTiempoEnAnden(bus);
        empresa.agregarHorarioLlegada(minutosLlegada, bus, origen, destino);
    }

    public void agregarHorarioSalida(Empresa empresa, String horaSalida, Bus bus, String origen, String destino) {
        int minutosSalida = ConversorHoras.convertirHoraAMinutos(horaSalida);
        asignarTiempoEnAnden(bus);
        empresa.agregarHorarioSalida(minutosSalida, bus, origen, destino);
    }
}
