package Lab2.src;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

public class SistemaVentas {

    public static List<Concierto> conciertos = new ArrayList<>();
    public static List<Usuario> usuarios = new ArrayList<>();
    public static void main(String[] args) 
        throws Exception {
            
            Usuario usuario1 = new Usuario("Kuilmer", "kuilmerhc@gmail.com", "3138778895");
            usuarios.add(usuario1);

            Usuario usuario2 = new Usuario("Dylan", "dylanrc@gmail.com", "3229503709");
            usuarios.add(usuario2);
            
            Lugar lugar1 = new Lugar("Vive Claro", "Carrera 60 # 42-41 - Bogotá", 40000);

            Concierto concierto1 = new Concierto("Festival Verano", LocalDate.of(2025, 11, 21), LocalTime.of(21, 0), lugar1, Arrays.asList("Blessed", "Jbalvin", "Ryan Castro"));

            conciertos.add(concierto1);





    }
}
