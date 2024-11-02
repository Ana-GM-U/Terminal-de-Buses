package clases;

import java.util.ArrayList;
import java.util.List;


public class Terminal {
    private String nombre;
    private List<Anden> andenesLLegada = new ArrayList<>();
    private List<Anden> andenesSalida = new ArrayList<>();
    private Cola<Bus> busesLLegada;
    private Cola<Bus> busesSalida;
    private List<Compania> companias;

    public Terminal(String nombre, List<Compania> companias, List<Anden> andenesLLegada, List<Anden> andenesSalida){
        this.nombre = nombre;
        for(int c = 0;c < companias.size(); c++){
            this.companias.add(companias.get(c));
        }

        for(int l = 0;l < andenesLLegada.size(); l++){
            this.andenesLLegada.add(andenesLLegada.get(l));
        }

        for(int s = 0;s < andenesSalida.size(); s++){
            this.andenesSalida.add(andenesSalida.get(s));
        }
    } 

    public List<Anden> getAndenesLLegada(){
        return this.andenesLLegada;
    }

    public List<Anden> getAndenesSalida(){
        return this.andenesSalida;
    }

    public void setAndenesLLegada(List<Anden> andenesLLegada){
        this.andenesLLegada.clear();
        for(int l = 0;l < andenesLLegada.size(); l++){
            this.andenesLLegada.add(andenesLLegada.get(l));
        }
        
    }

    public void setAndenesSalida(List<Anden> andenesSalida){
        this.andenesSalida.clear();
        for(int s = 0;s < andenesSalida.size(); s++){
            this.andenesSalida.add(andenesSalida.get(s));
        }
    }

    public void agregarBusLlegada(Bus bus){
        this.busesLLegada.enque(bus);
    }

    public void agregarBusSalida(Bus bus){
        this.busesSalida.enque(bus);
    }
   
}
