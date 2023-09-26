class Portero extends Jugador {
    int paradasEfectivas;
    int golesRecibidos;

    public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                   int paradasEfectivas, int golesRecibidos) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }

    public double calcularEfectividad() {
        return ((paradasEfectivas - golesRecibidos) * 100.0 / (paradasEfectivas + golesRecibidos)) +
               (golesDirectos * 100.0 / totalLanzamientos);
    }
}