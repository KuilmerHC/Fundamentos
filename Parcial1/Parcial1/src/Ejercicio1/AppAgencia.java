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
        Vuelo vuelo1 = new Vuelo(1, ciudad1, ciudad2, LocalTime.of(5, 30), LocalTime.of(7, 0), "1.30", 25);
        vuelos.add(vuelo1);

        // Creación de 3 Pasajeros
        Pasajero pasajero1 = new Pasajero(1234, "Kuilmer", 19, "Masculino");
        Pasajero pasajero2 = new Pasajero(5678, "David", 29, "Masculino");
        Pasajero pasajero3 = new Pasajero(12, "Allison", 23, "Femenino");

        // Cada pasajero compra un tiquete del vuelo
        Compra compra1 = new Compra(pasajero1);
        Tiquete tiquete1 = vuelo1.comprarTiqueteDisponible(pasajero1);
        compra1.agregarTiquete(tiquete1);
        compras.add(compra1);

        Compra compra2 = new Compra(pasajero2);
        Tiquete tiquete2 = vuelo1.comprarTiqueteDisponible(pasajero2);
        compra2.agregarTiquete(tiquete2);
        compras.add(compra2);

        Compra compra3 = new Compra(pasajero3);
        Tiquete tiquete3 = vuelo1.comprarTiqueteDisponible(pasajero3);
        compra3.agregarTiquete(tiquete3);
        compras.add(compra3);

        // Buscar un pasajero en un vuelo y mostrar sus datos y número de silla
        int idBusqueda = 1234; // Cambia por el id que quieras buscar
        boolean encontrado = false;
        for (Compra compra : compras) {
            if (compra.getPasajero().getId() == idBusqueda) {
                for (Tiquete t : compra.getTiquetesComprados()) {
                    if (t.getVuelo().getNumero() == vuelo1.getNumero()) {
                        Pasajero p = compra.getPasajero();
                        System.out.println("Pasajero encontrado:");
                        System.out.println("Identificación: " + p.getId());
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Género: " + p.getGenero());
                        System.out.println("Número de silla: " + t.getNumeroDeSilla());
                        encontrado = true;
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Pasajero no encontrado en el vuelo.");
        }

        vuelo1.mostrarTiquetesDisponibles();
    }
}
