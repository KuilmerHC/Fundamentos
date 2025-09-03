package Lab2.src;

/* 
 * Clase que crea Objetos de Lugar
 * @author Kuilmer
 */

public class Lugar {
    private String nombre;
    private String direccion;
    private int capacidad;

    public Lugar(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    } 
    
    
    @Override
    public String toString() {
        return "Lugar = nombre: " + nombre + ", direccion: " + direccion + ", capacidad: " + capacidad;
    }
    
}
