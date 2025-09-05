package Lab2.src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

/* 
 * Clase que crea Objetos de Conciertos
 * @author Kuilmer
 */

public class Concierto {
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private Lugar lugar;
    private List<String> artistas;
    private List<Boleto> boletos;

    public Concierto(String nombre, LocalDate fecha, LocalTime hora, Lugar lugar, List<String> artistas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.artistas = artistas;
        this.boletos = new ArrayList<>();
        inicializarBoletos();
    }

    /*
     * Boletos que son Parte de los Conciertos -> Se crean sus objetos
     * 20 iniciales tipo VIP por defecto
     * El restante tipo General
     */
    private void inicializarBoletos() {
        for (int i = 1; i <= lugar.getCapacidad(); i++) {
            TipoAsiento tipo = (i <= 20) ? TipoAsiento.VIP : TipoAsiento.General;
            double precio = (tipo == TipoAsiento.VIP) ? 150000 : 60000;

            String fila = (i <= 20) ? "A" : "B";
            Asiento asiento = new Asiento(i, fila, tipo);
            this.boletos.add(new Boleto(i, precio, asiento, this));
        }
    }

    /* Getters */
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<String> getArtistas() {
        return artistas;
    }

    public Lugar getLugar() {
        return lugar;
    }

    /*
     * Obtener solamente los boletos que no estén vendidos.
     */
    public List<Boleto> getBoletosDisponibles() {
        return boletos.stream()
                .filter(b -> b.getEstado() == EstadoBoleto.Disponible)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Concierto = nombre: " + nombre + ", fecha: " + fecha + ", hora: " + hora + ", lugar: " + lugar
                + ", artistas: " + artistas + ", boletos: " + boletos;
    }

}
