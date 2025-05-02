package Ejercicios1;

import java.util.List;

public class Vuelo {
    private String destino;
    private String fecha ;
    private int asiento;
    private List<Reserva>reservas;


    public Vuelo(String destino, String fecha, int asiento, List<Reserva> reservas) {
        this.destino = destino;
        this.fecha = fecha;
        this.asiento = asiento;
        this.reservas = reservas;
    }

    public Vuelo() {


    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "vuelo{" +
                "destino='" + destino + '\'' +
                ", fecha='" + fecha + '\'' +
                ", asiento=" + asiento +
                ", reservas=" + reservas +
                '}';
    }
}



