class Jugador {
    String nombre;
    String pais;
    int faltas;
    int golesDirectos;
    int totalLanzamientos;

    public Jugador(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos) {
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.golesDirectos = golesDirectos;
        this.totalLanzamientos = totalLanzamientos;
    }
}