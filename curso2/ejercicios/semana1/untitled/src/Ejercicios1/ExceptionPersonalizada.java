package Ejercicios1;

public class ExceptionPersonalizada extends Exception{
    public void ReservaInvalidaException(String mensaje){

    }

    public ExceptionPersonalizada(String mensaje) {
        super(mensaje);
    }
}
