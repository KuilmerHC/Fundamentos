package Ejercicio1;

import java.util.List;

/*
 * Clase crea Objetos de Compra
 * @KuilmerHC
 */
public class Compra {
    private Pasajero usuario;
    private Tiquete tiqueteComprado;


    public Compra(Pasajero usuario, Tiquete tiqueteComprado) {
        this.usuario = usuario;
        this.tiqueteComprado = tiqueteComprado;

    }

    /*
     * Getters
     */
    public Pasajero getUsuario() {
        return usuario;
    }

    public Tiquete getTiquete(){
        return tiqueteComprado;
    }

    /*
     * TO string
     */
    @Override
    public String toString() {
        return "Compra [usuario=" + usuario + ", tiquetesComprados=" + tiqueteComprado + "]";
    }

    
    
}
