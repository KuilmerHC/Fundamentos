package Lab2.src;

public class Asiento {
    private int numero;
    private String fila;
    private TipoAsiento tipo;


    public Asiento(int numero, String fila, TipoAsiento tipo) {
        this.numero = numero;
        this.fila = fila;
        this.tipo = tipo;
    }

    //Getters

    public int getNumero() {
        return numero;
    }

    public String getFila() {
        return fila;
    }

    public TipoAsiento getTipo() {
        return tipo;
    }
    

    @Override
    public String toString() {
        return "Asiento = numero: " + numero + ", fila: " + fila + ", tipo: " + tipo;
    }
    
}
