package Ejercicios1;

public class Reserva {
    private String nombre;
    private int asiento;

    public Reserva() {

    }

    public Reserva(String nombre, int asiento) {
        this.nombre = nombre;
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", asiento=" + asiento +
                '}';
    }
}
