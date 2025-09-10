package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

/*
 * Clase crea Objetos de Compra
 * @KuilmerHC
 */
public class Compra {
    private Pasajero pasajero;
    private List<Tiquete> tiquetesComprados;

    public Compra(Pasajero pasajero) {
        this.pasajero = pasajero;
        this.tiquetesComprados = new ArrayList<>();
    }

    /*
     * Método para agregar tiquetes a la compra
     */
    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetesComprados.add(tiquete);
    }

    /*
     * Getters
     */
    public Pasajero getPasajero() {
        return pasajero;
    }

    public List<Tiquete> getTiquetesComprados() {
        return tiquetesComprados;
    }

    /*
     * TO string
     */
    @Override
    public String toString() {
        return "Compra [usuario=" + pasajero + ", tiquetesComprados=" + tiquetesComprados + "]";
    }

}
