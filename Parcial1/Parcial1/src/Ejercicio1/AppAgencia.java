package Ejercicio1;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.List;

public class AppAgencia {

    public static List<Vuelo> vuelos = new ArrayList<>();
    public static List<Compra> compras = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // Creación de Ciudades
        Ciudad ciudad1 = new Ciudad("001", "Bogotá");
        Ciudad ciudad2 = new Ciudad("002", "Medellin");

        // Creación de Vuelos
        Vuelo vuelo1 = new Vuelo(01, ciudad1, ciudad2, LocalTime.of(5, 30), LocalTime.of(7, 0), "1.30", 25);

        // Creación de 3 Pasajeros
        Pasajero pasajero1 = new Pasajero(1234, "Kuilmer", 19, "Masculino");
        Pasajero pasajero2 = new Pasajero(5678, "David", 29, "Masculino");
        Pasajero pasajero3 = new Pasajero(0012, "Allison", 23, "Femenino");

        // Asignar Pasajeros
        Tiquete tiquete1 = vuelo1.getTiquetesDisponibles().get(0);
        Tiquete tiquete2 = vuelo1.getTiquetesDisponibles().get(0);
        Tiquete tiquete3 = vuelo1.getTiquetesDisponibles().get(0);

        Compra compra1 = new Compra(pasajero1, tiquete1);
        compras.add(compra1);

        Compra compra2 = new Compra(pasajero2, tiquete2);
        compras.add(compra2);

        Compra compra3 = new Compra(pasajero3, tiquete3);
        compras.add(compra3);

        // Buscar un pasajero por identificación en el vuelo
        int idBusqueda = 1234; // Cambia este valor para buscar otro pasajero
        Tiquete tiqueteEncontrado = null;
        for (Tiquete t : vuelo1.getListaTiquetes()) {
            if (t.getPasajero() != null && t.getPasajero().getIdentificacion() == idBusqueda) {
                tiqueteEncontrado = t;
                break;
            }
        }
        
        if (tiqueteEncontrado != null) {
            Pasajero p = tiqueteEncontrado.getPasajero();
            System.out.println("Pasajero encontrado:");
            System.out.println("Identificación: " + p.getIdentificacion());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Género: " + p.getGenero());
            System.out.println("Número de silla: " + tiqueteEncontrado.getNumeroAsiento());
        } else {
            System.out.println("Pasajero no encontrado en el vuelo.");
        }

    }
}
