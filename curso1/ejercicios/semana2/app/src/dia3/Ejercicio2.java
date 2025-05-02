package dia3;

public class Ejercicio2 {


public class Ejercicio2 {
    public static void main(String[] args) {
        generaQuinielasConProbabilidades(10);
    }

    private static void generaQuinielasConProbabilidades(int numeroResultados) {
        char resultado = '1';
        for (int i = 0; i < numeroResultados; i++) {
            // Genéro número random entre 0 y 9
            int numRandom = (int) Math.floor(Math.random() * 9);
            switch (numRandom) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    // Si numRandom es 0,1,2,3,4,5
                    // pongo en resultado el valor 1 para simular una probabilidad del 60% (6 de 10 números = 60%)
                    // IMPORTANTE: si en el case no tengo break se sigue con los cases hasta llegar al primero con break
                    resultado = '1';
                    break;
                case 6:
                case 7:
                case 8:
                    // Si numRandom es 6,7,8
                    // pongo en resultado el valor 2 para simular una probabilidad del 30% (3 de 10 números = 30%)
                    resultado = '2';
                    break;
                case 9:
                    // Si el numRandom es 9 el resultado es X (1 de 10 números = 10%)
                    resultado = 'X';
                    break;
            }

            System.out.println("Resultado " + (i + 1) + " = " + resultado);
        }
    }
