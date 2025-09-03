package Lab2.src;

/* 
 * Clase que crea Objetos de Lugar
 * @author Kuilmer
 */

public class Usuario {
    private String nombre;
    private String correo;
    private String telefono;

    public Usuario(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    
    @Override
    public String toString() {
        return "Usuario = nombre: " + nombre + ", correo: " + correo + ", telefono: " + telefono;
    }

    
}

