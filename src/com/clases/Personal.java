package clases;

public class Personal {
    private String rut;
    private String nombre;

    public Personal(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }
}

class Chofer extends Personal {
    public Chofer(String rut, String nombre) {
        super(rut, nombre);
    }
}

class Ayudante extends Personal {
    public Ayudante(String rut, String nombre) {
        super(rut, nombre);
    }
}
