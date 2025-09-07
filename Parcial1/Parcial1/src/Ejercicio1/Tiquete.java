package Ejercicio1;

public class Tiquete {

    private int numero;
    private Estado estado;


    public Tiquete(int numero) {
        this.numero = numero;
        this.estado = Estado.Disponible;
    }


    public int getNumero() {
        return numero;
    }


    public Estado getEstado() {
        return estado;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}
