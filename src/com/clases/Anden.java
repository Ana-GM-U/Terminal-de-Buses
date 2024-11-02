package clases;

public class Anden {
    private boolean ocupado = false;
    private Bus bus;

    public Anden(){
        this.ocupado = false;
    }
    public boolean getOcupado(){
        return this.ocupado;
    }
    public Bus getBus(){
        return this.bus;
    }

    public void ocupar(Bus bus){
        if(this.ocupado != true){
            this.ocupado = true;
            this.bus = bus;
        }
    }

    public void desocupar(){
        if(this.ocupado != false){
            this.ocupado = false;
            this.bus = null;
        }
    }
    
}
