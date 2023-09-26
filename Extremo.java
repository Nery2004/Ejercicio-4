class Extremo extends Jugador {
    int pases;
    int asistenciasEfectivas;

    public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                   int pases, int asistenciasEfectivas) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.pases = pases;
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    public double calcularEfectividad() {
        return ((pases + asistenciasEfectivas - faltas) * 100.0 / (pases + asistenciasEfectivas + faltas)) +
               (golesDirectos * 100.0 / totalLanzamientos);
    }
}