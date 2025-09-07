package Ejercicio1;

import java.util.*;


public class Vuelo {

    private int numero;
    private int nSillas;
    private List<Tiquete> listaTiquetes;


    public Vuelo(int numero, int nSillas) {
        this.numero = numero;
        this.nSillas = nSillas;

        listaTiquetes = new ArrayList();
        int numeroT = 100;
        for (int i = 0; i < nSillas; i++) {
            Tiquete tiquete = new Tiquete(numeroT);
            numeroT++;
            listaTiquetes.add(tiquete);
        }
    }

    public void mostrarTiquetesDisponibles(){
        for (Tiquete tiquete : listaTiquetes) {
            if (tiquete.getEstado().equals(Estado.Disponible))
                System.out.println(tiquete);
        }
    }

    public void cambiarEstado(Tiquete tiquete) {
        tiquete.setEstado(Estado.Vendido);
    }

    



    
    
}
