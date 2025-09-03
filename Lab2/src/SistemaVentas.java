package Lab2.src;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SistemaVentas {

    public static List<Concierto> conciertos = new ArrayList<>();
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Compra> compras = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Usuarios
        usuarios.add(new Usuario("Kuilmer", "kuilmerhc@gmail.com", "3138778895"));
        usuarios.add(new Usuario("Dylan", "dylanry@gmail.com", "3229503709"));

        // Lugares
        Lugar lugar1 = new Lugar("Vive Claro", "Carrera 60 # 42-41 - Bogotá", 150);
        Lugar lugar2 = new Lugar("Movistar Arena", "Dg. 61c #26-35, - Bogotá", 100);

        // Conciertos
        conciertos.add(new Concierto("Festival Verano", LocalDate.of(2025, 11, 21), LocalTime.of(21, 0), lugar1,
                Arrays.asList("Blessd", "JBalvin", "Ryan Castro")));
        conciertos.add(new Concierto("Don KBRN World Tour", LocalDate.of(2025, 10, 10), LocalTime.of(20, 0),
                lugar2, Arrays.asList("Eladio Carrion")));

        System.out.println("--------- Bienvenido al Sistema de Ventas de Boletería para Conciertos ---------");

        // Selección de usuario
        Usuario usuarioActual = seleccionarUsuario(scanner);

        // Menú principal
        while (true) {
            System.out.println("\n-> Seleccione una opción:");
            System.out.println("1. Buscar conciertos");
            System.out.println("2. Ver mis compras");
            System.out.println("3. Salir");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                Concierto conciertoSeleccionado = buscarConciertoInteractivo(scanner);
                if (conciertoSeleccionado == null)
                    continue;

                List<Boleto> boletosDisponibles = conciertoSeleccionado.getBoletosDisponibles();
                if (boletosDisponibles.isEmpty()) {
                    System.out.println("No hay boletos disponibles para este concierto.");
                    continue;
                }
                System.out.println(" --- Asientos Disponibles --- ");
                boletosDisponibles.forEach(System.out::println);

                List<Boleto> boletosSeleccionados = seleccionarBoletos(scanner, boletosDisponibles);
                if (boletosSeleccionados.isEmpty())
                    continue;

                // Registrar la compra
                Compra compra = new Compra(usuarioActual, boletosSeleccionados, LocalDate.now());
                compras.add(compra);
                System.out.println("Compra realizada:");
                System.out.println(compra);
                System.out.println("Confirmación de compra:");
                System.out.println(generarConfirmacion(compra));
            } else if (opcion.equals("2")) {
                mostrarComprasUsuario(usuarioActual);
            } else if (opcion.equals("3")) {
                System.out.println("¡Gracias, Hasta pronto!");
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    // Selección de usuario
    public static Usuario seleccionarUsuario(Scanner scanner) {
        while (true) {
            System.out.println(" --> Seleccione su usuario: ");

            for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
            }

            String entradausr = scanner.nextLine();
            int idx;

            try {
                idx = Integer.parseInt(entradausr) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
                continue;
            }

            if (idx < 0 || idx >= usuarios.size()) {
                System.out.println("Usuario inválido. Intente de nuevo");
                continue;
            }
            return usuarios.get(idx);
        }
    }

    // Menú de búsqueda de conciertos
    public static Concierto buscarConciertoInteractivo(Scanner scanner) {
        System.out.println("--> Buscar concierto por:");
        System.out.println("1. Nombre");
        System.out.println("2. Fecha");
        System.out.println("3. Artista");

        String tipo = scanner.nextLine();
        List<Concierto> resultados = new ArrayList<>();
        if (tipo.equals("1")) {
            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();
            resultados = buscaConciertosPorNombre(nombre);

        } else if (tipo.equals("2")) {
            System.out.println("Ingrese la fecha (YYYY-MM-DD):");
            String fechaStr = scanner.nextLine();
            try {
                LocalDate fecha = LocalDate.parse(fechaStr);
                resultados = buscaConciertosPorFecha(fecha);
            } catch (Exception e) {
                System.out.println("Fecha inválida.");
            }

        } else if (tipo.equals("3")) {
            System.out.println("Ingrese el nombre del artista:");
            String artista = scanner.nextLine();
            resultados = buscaConciertosPorArtista(artista);

        } else {
            System.out.println("Opción inválida.");
            return null;
        }
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron conciertos.");
            return null;
        }

        System.out.println("Conciertos encontrados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i).getNombre() + " - " + resultados.get(i).getFecha());
        }
        System.out.println("Seleccione el concierto:");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx < 0 || idx >= resultados.size()) {
            System.out.println("Selección inválida.");
            return null;
        }
        return resultados.get(idx);
    }

    // Selección de boletos
    public static List<Boleto> seleccionarBoletos(Scanner scanner, List<Boleto> boletosDisponibles) {
        List<Boleto> seleccionados = new ArrayList<>();
        System.out.println("¿Cuántos boletos desea comprar?");
        int cantidad;

        try {
            cantidad = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
            return seleccionados;
        }

        if (boletosDisponibles.size() < cantidad) {
            System.out.println("No hay suficientes boletos disponibles.");
            return seleccionados;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el número de asiento que desea comprar:");
            int numeroAsiento;
            try {
                numeroAsiento = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número de asiento inválido.");
                i--;
                continue;
            }

            Boleto boleto = boletosDisponibles.stream()
                    .filter(b -> b.getAsiento().getNumero() == numeroAsiento
                            && b.getEstado() == EstadoBoleto.Disponible)
                    .findFirst()
                    .orElse(null);
            if (boleto != null) {
                seleccionados.add(boleto);
                boleto.setEstado(EstadoBoleto.Vendido);
            } else {
                System.out.println("Asiento no disponible, seleccione otro.");
                i--;
            }
        }
        return seleccionados;
    }

    // Mostrar compras del usuario
    public static void mostrarComprasUsuario(Usuario usuario) {
        List<Compra> misCompras = compras.stream()
                .filter(c -> c.getUsuario().equals(usuario))
                .collect(Collectors.toList());
        if (misCompras.isEmpty()) {
            System.out.println("No tienes compras registradas.");
        } else {
            System.out.println("Tus compras:");
            misCompras.forEach(System.out::println);
        }
    }

    // Confirmación de compra
    public static String generarConfirmacion(Compra compra) {
        StringBuilder sb = new StringBuilder();
        sb.append("Concierto: ").append(compra.getBoletosComprados().get(0).getConcierto().getNombre()).append("\n");
        sb.append("Fecha: ").append(compra.getBoletosComprados().get(0).getConcierto().getFecha()).append("\n");
        sb.append("Lugar: ").append(compra.getBoletosComprados().get(0).getConcierto().getLugar().getNombre())
                .append("\n");
        sb.append("Boletos:\n");
        for (Boleto b : compra.getBoletosComprados()) {
            sb.append("  Asiento: ").append(b.getAsiento().getNumero())
                    .append(" Fila: ").append(b.getAsiento().getFila())
                    .append(" Tipo: ").append(b.getAsiento().getTipo())
                    .append(" Precio: ").append(b.getPrecio()).append("\n");
        }
        sb.append("Estado: Vendido\n");
        sb.append("Fecha de compra: ").append(compra.getFecha()).append("\n");
        sb.append("Usuario: ").append(compra.getUsuario().getNombre()).append("\n");
        return sb.toString();
    }

    // Búsquedas
    public static List<Concierto> buscaConciertosPorNombre(String nombre) {
        return conciertos.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Concierto> buscaConciertosPorArtista(String artista) {
        return conciertos.stream()
                .filter(c -> c.getArtistas().stream()
                        .anyMatch(a -> a.toLowerCase().contains(artista.toLowerCase())))
                .collect(Collectors.toList());
    }

    public static List<Concierto> buscaConciertosPorFecha(LocalDate fecha) {
        return conciertos.stream()
                .filter(c -> c.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}
