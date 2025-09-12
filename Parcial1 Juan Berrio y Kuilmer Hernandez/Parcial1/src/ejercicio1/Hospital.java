package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public static List<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        registrarPaciente();

        Examen examen1 = new Examen(001, TipoExamen.Holter, "El paciente se encuentra en buenas condiciones");
        agregarExamenPaciente(1, examen1);

        Tratamiento tratamiento1 = new Tratamiento(TipoTratamiento.Medicamentos, 001, "Acetaminofen", 8,
                "Sin efectos secundarios");
        agregarTratamientoPaciente(2, tratamiento1);

        // Obtener y mostrar el número de pacientes mujeres con enfermedad cardiaca
        int mujeresCardiopatia = contarPacientesMujeresPorEnfermedad(TipoEnfermedad.Cardiaca);
        System.out.println("Pacientes mujeres con cardiopatía: " + mujeresCardiopatia);

        imprimirPorcentajePacientesPorEstado();
    }

    public static void registrarPaciente() {
        pacientes.add(new Paciente(1, "Ana Torres", 30, TipoEnfermedad.Cardiaca, EstadoPaciente.En_Remision,
                GeneroPaciente.Mujer));

        pacientes.add(new Paciente(2, "Luis Pérez", 45, TipoEnfermedad.Hipertension, EstadoPaciente.Tratamiento,
                GeneroPaciente.Hombre));

        pacientes.add(new Paciente(3, "María Gómez", 25, TipoEnfermedad.Insuficiencia, EstadoPaciente.En_Remision,
                GeneroPaciente.Mujer));

        pacientes.add(new Paciente(4, "Carlos Ruiz", 60, TipoEnfermedad.Cardiopatia, EstadoPaciente.Hospitalizacion,
                GeneroPaciente.Hombre));

        pacientes.add(new Paciente(5, "Lucía Fernández", 50, TipoEnfermedad.Hipertension, EstadoPaciente.Tratamiento,
                GeneroPaciente.Mujer));
    }

    public static void agregarExamenPaciente(int idPaciente, Examen examen) {
        for (Paciente p : pacientes) {
            if (p.getIdPaciente() == idPaciente) {
                p.agregarExamen(examen);
                break;
            }
        }
    }

    public static void agregarTratamientoPaciente(int idPaciente, Tratamiento tratamiento) {
        for (Paciente p : pacientes) {
            if (p.getIdPaciente() == idPaciente) {
                p.agregarTratamiento(tratamiento);
                break;
            }
        }
    }

    public static int contarPacientesMujeresPorEnfermedad(TipoEnfermedad enfermedad) {
        int contador = 0;
        for (Paciente p : pacientes) {
            if (p.getGenero() == GeneroPaciente.Mujer && p.getTipoEnfermedad() == enfermedad) {
                contador++;
            }
        }
        return contador;
    }

    public static void imprimirPorcentajePacientesPorEstado() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        int total = pacientes.size();
        // Contador por estado
        java.util.Map<EstadoPaciente, Integer> conteo = new java.util.HashMap<>();

        for (Paciente p : pacientes) {
            EstadoPaciente estado = p.getEstadoActual();
            conteo.put(estado, conteo.getOrDefault(estado, 0) + 1);
        }

        System.out.println("Porcentaje de pacientes por estado:");
        for (EstadoPaciente estado : EstadoPaciente.values()) {
            int cantidad = conteo.getOrDefault(estado, 0);
            double porcentaje = (cantidad * 100.0) / total;
            System.out.printf("- %s: %.1f%% (%d pacientes)%n", estado, porcentaje, cantidad);
        }
    }

}
