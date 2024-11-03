package clases;

import java.io.Serializable;

public class Personal implements Serializable{
    private static final long serialVersionUID = 6L;

    private String nombre;
    private String apellido;
    private String rol;

    public Personal(String nombre, String apellido, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRol() {
        return rol;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
