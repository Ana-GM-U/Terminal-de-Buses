package clases;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private static final long serialVersionUID = 4L;

    private String nombre;
    private List<HorarioBus> horariosLlegada;
    private List<HorarioBus> horariosSalida;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.horariosLlegada = new ArrayList<>();
        this.horariosSalida = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarHorarioLlegada(int horaLlegada, Bus bus, String origen, String destino) {
        bus.setEmpresa(nombre);
        horariosLlegada.add(new HorarioBus(horaLlegada, bus, origen, destino));
    }

    public void agregarHorarioSalida(int horaSalida, Bus bus, String origen, String destino) {
        bus.setEmpresa(nombre);
        horariosSalida.add(new HorarioBus(horaSalida, bus, origen, destino));
    }

    public Bus obtenerBusLlegada(int horaActual) {
        for (HorarioBus horario : horariosLlegada) {
            if (horario.getHora() == horaActual) {
                return horario.getBus();
            }
        }
        return null;
    }

    public Bus obtenerBusSalida(int horaActual) {
        for (HorarioBus horario : horariosSalida) {
            if (horario.getHora() == horaActual) {
                return horario.getBus();
            }
        }
        return null; 
    }
}
