//Nery Molina 23218
//Ejercicio 4
//Importar Scanner, arraylist y collections que servira para que java pueda leer utilizar estos packages
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//Crear una clase main donde tenga un scanner y un arraylist para los jugadores 
public class TorneoBalonmano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        //Crear un boolean donde imprima las opciones del menu
        while (true) {
            System.out.println("\n---Torneo de Balonmano---");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Mostrar Nombres de Jugadores Registrados");
            System.out.println("3. Mostrar los 3 Mejores Porteros");
            System.out.println("4. Contar Extremos con más de 85 de Efectividad");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            //Cuando el usuario ingrese alguna de estas opciones 
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
                    //Si el usuario ingresa 1 tendra que llenar el formulario del jugador
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
                    }//El usuario despues de llenar la informacion del Jugador debera elegir si es un portero o si es un extremo dependiendo de esto
                    ///creamos un if para asi poder hacer diferentes preguntas dependiendo de la clase que este elija
                    break;
                case 2:
                    System.out.println("\nNombres de Jugadores Registrados:");
                    for (Jugador jugador : jugadores) {
                        System.out.println(jugador.nombre);
                    } //imprime todos los nombres de los jugadores con la variable jugador.nombre
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
                    break;// LLama el arraylist de todos los que son de la clase portero y los ordena de top 3 con los resultados que dieron para asi solo imprimir los que estan en el rango de i
            case 4:
                int extremosConMasDe85Efectividad = 0;
                for (Jugador jugador : jugadores) {
                    if (jugador instanceof Extremo) {
                        Extremo extremo = (Extremo) jugador;
                        if (extremo.calcularEfectividad() > 85) {
                            extremosConMasDe85Efectividad++;
                        }///se hace la comparacion de los calcluos que ya tenian los extremos y se comparar con 85 para ver cuatnos cumplen con esta efectividad 
                    }
                }
                System.out.println("\nCantidad de Extremos con más de 85 de Efectividad: " + extremosConMasDe85Efectividad);
                break;//llama a la variable si es que si se cumple se le pone un ++ porque se le va sumando y solo llamamos a la variable que seria la cantidad que se le esta sumando 
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);//sale del programa 
                default:
                    System.out.println("Opción no válida.");
                    break;// opcion defensiva por si el usuario ingresa un numero que no esta en el menu o una letra que no este en ninguna de las opciones 
            }
        }
    }
}