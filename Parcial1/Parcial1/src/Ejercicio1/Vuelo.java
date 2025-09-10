package Ejercicio1;

import java.time.LocalTime;
import java.util.*;

/*
 * Clase para crear Objetos de Vuelo
 * @KuilmerHC
 */
public class Vuelo {

    private int numero;
    private Ciudad ciudadSalida;
    private Ciudad ciudadDestino;
    private LocalTime horaDeSalida;
    private LocalTime horaDeLlegada;
    private String duracion;
    private int numeroDeSillas;
    private List<Tiquete> listaTiquetes;

    public Vuelo(int numero, Ciudad ciudadSalida, Ciudad ciudadDestino, LocalTime horaDeSalida, LocalTime horaDeLlegada,
            String duracion, int nSillas) {
        this.numero = numero;
        this.ciudadSalida = ciudadSalida;
        this.ciudadDestino = ciudadDestino;
        this.horaDeSalida = horaDeSalida;
        this.horaDeLlegada = horaDeLlegada;
        this.duracion = duracion;
        this.numeroDeSillas = nSillas;
        this.listaTiquetes = new ArrayList<>();
        crearTiquetes();
    }

    /*
     * Crear Tiquetes del Vuelo según la cantidad de sillas en el Vuelo (avión)
     */
    private void crearTiquetes() {
        for (int i = 1; i <= numeroDeSillas; i++) {
            listaTiquetes.add(new Tiquete(i, this, "#Numero: " + i));
        }
    }

    /*
     * Tiquetes disponibles
     */
    public List<Tiquete> getTiquetesDisponibles() {
        List<Tiquete> disponibles = new ArrayList<>();
        for (Tiquete tiquete : listaTiquetes) {
            if (tiquete.getEstado().equals(Estado.Disponible)) {
                disponibles.add(tiquete);
            }
        }
        return disponibles;
    }

    /*
     * Getters
     * 
     */

    public int getNumero() {
        return numero;
    }

    public Ciudad getCiudadSalida() {
        return ciudadSalida;
    }

    public LocalTime getHoraDeSalida() {
        return horaDeSalida;
    }

    public LocalTime getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public List<Tiquete> getListaTiquetes() {
        return listaTiquetes;
    }

    /*
     * Cambiar Estado
     */
    public void cambiarEstado(Tiquete tiquete) {
        tiquete.setEstado(Estado.Vendido);
    }

    /*
     * Tiquetes Disponibles
     */
    public void mostrarTiquetesDisponibles() {
        for (Tiquete tiquete : listaTiquetes) {
            if (tiquete.getEstado().equals(Estado.Disponible))
                System.out.println(tiquete);
        }
    }

    public Tiquete buscarTiquete(int numero) {
        for (Tiquete tiquete : listaTiquetes) {
            if (tiquete.getNumero() == numero)
                return tiquete;
        }
        System.out.println("Error! El Numero de Tiquete NO Exise");
        return null;
    }

    // Método para asignar un tiquete disponible a un pasajero
    public Tiquete comprarTiqueteDisponible(Pasajero pasajero) {
        for (Tiquete t : listaTiquetes) {
            if (!t.isVendido()) {
                t.asignarPasajero(pasajero);
                return t;
            }
        }
        return null; // No hay tiquetes disponibles
    }


    /*
     * To string
     */
    @Override
    public String toString() {
        return "Vuelo [numero=" + numero + ", ciudadSalida=" + ciudadSalida + ", ciudadDestino=" + ciudadDestino
                + ", horaDeSalida=" + horaDeSalida + ", horaDeLlegada=" + horaDeLlegada + ", duracionVuelo="
                + duracion + ", numeroDeSillas=" + numeroDeSillas + ", listaTiquetes=" + listaTiquetes + "]";
    }

}
