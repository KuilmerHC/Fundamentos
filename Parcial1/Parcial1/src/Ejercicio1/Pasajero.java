package Ejercicio1;

public class Pasajero {
    private int id;
    private String nombre;
    private int edad;
    private String genero;


    public Pasajero(int id, String nombre, int edad, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }


     /* 
     * Getters
     */

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public int getEdad() {
        return edad;
    }


    public String getGenero() {
        return genero;
    }


    /* 
    * To String
     */
    
    public String toString() {
        return "Pasajero [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + "]";
    }


}
