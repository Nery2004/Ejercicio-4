class Extremo extends Jugador {
    int pases;
    int asistenciasEfectivas;
//crear la clase extremo que viene del padre de Jugador y int de lo que ponga en usuario para pases o asistencias
    public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                   int pases, int asistenciasEfectivas) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.pases = pases;
        this.asistenciasEfectivas = asistenciasEfectivas;
    }///definir

    public double calcularEfectividad() {
        return ((pases + asistenciasEfectivas - faltas) * 100.0 / (pases + asistenciasEfectivas + faltas)) +
               (golesDirectos * 100.0 / totalLanzamientos);
    }
}//crear los calculos para la efectividad con las variables que le pertecen que puso en esta clase y las que puso anteriormente con el padre