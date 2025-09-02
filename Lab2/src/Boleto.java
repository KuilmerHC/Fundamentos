package Lab2.src;

public class Boleto {
    private int id;
    private double precio;
    private EstadoBoleto estado;
    private Concierto concierto;
    private Asiento asiento;


    public Boleto(int id, double precio, Asiento asiento) {
        this.id = id;
        this.precio = precio;
        this.estado = EstadoBoleto.Disponible;
        this.asiento = asiento;
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

    
    /*
     * Setter -> Cambiar el estado por Vendido
     */
    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Boleto = id: " + id + ", precio: " + precio + ", estado: " + estado + ", concierto: " + concierto
                + ", asiento: " + asiento;
    }

    
}
