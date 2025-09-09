package Ejercicio1;

import java.time.LocalDate;


/* 
 * Clase crea OBjetos de Tiquete
 * @author KuilmerHC
*/

public class Tiquete {
    private int numero;
    private Vuelo vuelo;
    private LocalDate fechaDeCompra;
    private String numeroDeSilla;
    private Estado estado;


    public Tiquete(int numero,Vuelo vuelo, String numeroDeSilla) {
        this.numero = numero;
        this.vuelo = vuelo;
        this.fechaDeCompra = LocalDate.now();
        this.numeroDeSilla = numeroDeSilla;
        this.estado = Estado.Disponible;
    }

    /*
     * Setter -> Cambiar Estado a Vendido.
     */

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /*
     * Getters
     */
    
    public int getNumero() {
        return numero;
    }

    public LocalDate getFechaDeCompra() {
        return fechaDeCompra;
    }

    public String getNumeroDeSilla() {
        return numeroDeSilla;
    }

    public Estado getEstado() {
        return estado;
    }



    /*
     * To string
     */
    @Override
    public String toString() {
        return "Tiquete [numero=" + numero + ", fechaDeCompra=" + fechaDeCompra + ", numeroDeSilla=" + numeroDeSilla
                + ", estado=" + estado + "]";
    }


    
}
