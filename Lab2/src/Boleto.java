package Lab2.src;

/* 
 * Clase que crea Objetos de Boleto
 * @author Kuilmer
 */

public class Boleto {
    private int id;
    private double precio;
    private EstadoBoleto estado;
    private Asiento asiento;
    private Concierto concierto;

    /*
     * El Estado del Asiento será Disponible cuando se crea.
     */
    
    public Boleto(int id, double precio, Asiento asiento, Concierto concierto) {
        this.id = id;
        this.precio = precio;
        this.asiento = asiento;
        this.estado = EstadoBoleto.Disponible;
        this.concierto = concierto;
    }

    /* Getters */
    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public Concierto getConcierto() {
        return concierto;
    }

    /*
     * Setter -> Cambiar el estado por Vendido
     */
    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\n Boleto = id: " + id + ", precio: " + precio + ", estado: " + estado;
    }

}
