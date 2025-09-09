package Ejercicio1;

public class Ciudad {
    private String codigo;
    private String nombre;


    public Ciudad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /*
     * Getters
     */

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    /*
     * To string
     */
    @Override
    public String toString() {
        return "Ciudad [codigo=" + codigo + ", nombre=" + nombre + "]";
    }

    
}
