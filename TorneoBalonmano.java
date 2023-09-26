import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TorneoBalonmano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        while (true) {
            System.out.println("\n---Torneo de Balonmano---");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Mostrar Nombres de Jugadores Registrados");
            System.out.println("3. Mostrar los 3 Mejores Porteros");
            System.out.println("4. Contar Extremos con más de 85 de Efectividad");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Nombre del jugador: ");
                    String nombre = scanner.nextLine();
                    System.out.print("País: ");
                    String pais = scanner.nextLine();
                    System.out.print("Faltas: ");
                    int faltas = scanner.nextInt();
                    System.out.print("Goles Directos: ");
                    int golesDirectos = scanner.nextInt();
                    System.out.print("Total de Lanzamientos: ");
                    int totalLanzamientos = scanner.nextInt();
                    System.out.print("¿Es portero (1) o extremo (2)? ");
                    int tipoJugador = scanner.nextInt();

                    if (tipoJugador == 1) {
                        System.out.print("Paradas Efectivas: ");
                        int paradasEfectivas = scanner.nextInt();
                        System.out.print("Goles Recibidos: ");
                        int golesRecibidos = scanner.nextInt();
                        jugadores.add(new Portero(nombre, pais, faltas, golesDirectos, totalLanzamientos,
                                paradasEfectivas, golesRecibidos));
                    } else if (tipoJugador == 2) {
                        System.out.print("Pases: ");
                        int pases = scanner.nextInt();
                        System.out.print("Asistencias Efectivas: ");
                        int asistenciasEfectivas = scanner.nextInt();
                        jugadores.add(new Extremo(nombre, pais, faltas, golesDirectos, totalLanzamientos,
                                pases, asistenciasEfectivas));
                    } else {
                        System.out.println("Tipo de jugador no válido.");
                    }
                    break;
                case 2:
                    System.out.println("\nNombres de Jugadores Registrados:");
                    for (Jugador jugador : jugadores) {
                        System.out.println(jugador.nombre);
                    }
                    break;
                case 3:
                    ArrayList<Portero> porteros = new ArrayList<>();
                    for (Jugador jugador : jugadores) {
                        if (jugador instanceof Portero) {
                            porteros.add((Portero) jugador);
                        }
                    }

                    Collections.sort(porteros, (a, b) -> Double.compare(b.calcularEfectividad(), a.calcularEfectividad()));

                    System.out.println("\nLos 3 Mejores Porteros:");
                    for (int i = 0; i < Math.min(3, porteros.size()); i++) {
                        Portero portero = porteros.get(i);
                        System.out.println("Nombre: " + portero.nombre);
                        System.out.println("Efectividad: " + portero.calcularEfectividad());
                    }
                    break;
            case 4:
                int extremosConMasDe85Efectividad = 0;
                for (Jugador jugador : jugadores) {
                    if (jugador instanceof Extremo) {
                        Extremo extremo = (Extremo) jugador;
                        if (extremo.calcularEfectividad() > 85) {
                            extremosConMasDe85Efectividad++;
                        }
                    }
                }
                System.out.println("\nCantidad de Extremos con más de 85 de Efectividad: " + extremosConMasDe85Efectividad);
                break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}