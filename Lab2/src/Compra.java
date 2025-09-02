package Lab2.src;

import java.time.LocalDate;
import java.util.List;

public class Compra {
    private Usuario usuario;
    private List<Boleto> boletoscomprados;
    private LocalDate fecha;
    private double total;

    public Compra(Usuario usuario, List<Boleto> boletoscomprados, LocalDate fecha) {
        this.usuario = usuario;
        this.boletoscomprados = boletoscomprados;
        this.fecha = fecha;
        this.total = 0;
        
    /*
     *    1. Calcula el valor total de los boletos
     * 2. Cambia el estado de los boletos.
     */
    for (Boleto boleto: boletoscomprados){
        boleto.setEstado(EstadoBoleto.Vendido);
        this.total += boleto.getPrecio();
        }
    
    }

    /* Getters */
        public Usuario getUsuario() {
        return usuario;
    }

    public List<Boleto> getBoletoscomprados() {
        return boletoscomprados;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Compra del usuario: " + usuario + ", boletoscomprados: " + boletoscomprados + ", fecha: " + fecha + ", total: " + total;
    }

    
    
}
