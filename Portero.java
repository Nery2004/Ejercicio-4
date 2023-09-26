class Portero extends Jugador {
    int paradasEfectivas;
    int golesRecibidos;
//crear la clase extremo que viene del padre de Jugador y int  de lo que ponga en usuario para pases o asistencias
    public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                   int paradasEfectivas, int golesRecibidos) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }//definir

    public double calcularEfectividad() {
        return ((paradasEfectivas - golesRecibidos) * 100.0 / (paradasEfectivas + golesRecibidos)) +
               (golesDirectos * 100.0 / totalLanzamientos);
    }
}//crear los calculos para la efectividad con las variables que le pertecen que puso en esta clase y las que puso anteriormente con el padre