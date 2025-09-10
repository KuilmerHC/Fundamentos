package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private int idPaciente;
    private String nombre;
    private int edad;
    private TipoEnfermedad tipoEnfermedad;
    private EstadoPaciente estadoActual;
    private GeneroPaciente genero;
    private List<Tratamiento> historialTratamientos;
    private List<Examen> examenes;


    public Paciente(int idPaciente, String nombre, int edad, TipoEnfermedad tipoEnfermedad, EstadoPaciente estadoActual,
            GeneroPaciente genero) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoEnfermedad = tipoEnfermedad;
        this.estadoActual = estadoActual;
        this.genero = genero;
        this.historialTratamientos = new ArrayList<>();
        this.examenes = new ArrayList<>();
    }

    /*
     * Getters 
     */
    
     
    public TipoEnfermedad getTipoEnfermedad() {
        return tipoEnfermedad;
    }


    public int getIdPaciente() {
        return idPaciente;
    }

    public GeneroPaciente getGenero() {
        return genero;
    }

    public EstadoPaciente getEstadoActual() {
        return estadoActual;
    }  

    public void agregarExamen(Examen examen){
        this.examenes.add(examen);
    }

    public void agregarTratamiento(Tratamiento tratamiento){
        this.historialTratamientos.add(tratamiento);
    }

    public void porcentajePorEstado(){

    }
}
