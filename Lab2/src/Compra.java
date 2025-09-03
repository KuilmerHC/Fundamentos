package Lab2.src;

import java.time.LocalDate;
import java.util.List;


/* 
 * Clase que crea Objetos de Compra
 * @author Kuilmer
 */

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
     * 1. Calcula el valor total de los boletos
     * 2. Cambia el estado de los boletos.
     * 3. Guardo el total en el atributo de Compra.
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

    public List<Boleto> getBoletosComprados() {
        return boletoscomprados;
    }

    public double getTotal() {
        return total;
    }

     public LocalDate getFecha() {
        return fecha;
    }


    @Override
    public String toString() {
        return "Compra del usuario: " + usuario + ", boletoscomprados: " + boletoscomprados + ", fecha: " + fecha + ", total: " + total;
    }
    
    
}
