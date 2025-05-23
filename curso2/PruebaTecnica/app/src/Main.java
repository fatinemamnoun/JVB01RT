import entities.Vuelo;
import utils.FiltroVuelos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // aqui he podido probar con 2024 y 2026 y me salio que no hay vuelos disponibles y tambien probe con y sin fechaDesde y fechaHasta y me salio bien
        // lo deje en null y comente las fechas para poder probar lo del null-> devolver todos los vuelos ordenados por id.


        final LocalDate fechaDesde =null;//LocalDate.of(2025,7,1) ; // no lleva static porque dentro de un metodo
        final LocalDate fechaHasta =null;//LocalDate.of(2025,12,30); // no lleva static porque dentro de un metodo

        // lista de vuelos

        List<Vuelo> vuelos =new ArrayList<>();
        vuelos.add(new Vuelo(1,"k122","AirKorea","Seoul","Madrid",LocalDate.of(2025,5,20),LocalDate.of(2025,5,21)));
        vuelos.add(new Vuelo(2,"D122","AirNippon","Tokyo","Hanoi",LocalDate.of(2025,6,20),LocalDate.of(2025,6,21)));
        vuelos.add(new Vuelo(3,"F122","AirChina","Shangahai","Bangkok",LocalDate.of(2025,9,20),LocalDate.of(2025,9,21)));
        vuelos.add(new Vuelo(4,"D122","AirColombia","Bogota","Osaka",LocalDate.of(2025,7,20),LocalDate.of(2025,7,21)));
        vuelos.add(new Vuelo(5,"D255","AirSaudia","Jeddah","Seoul",LocalDate.of(2025,8,20),LocalDate.of(2025,8,21)));
        vuelos.add(new Vuelo(6,"C133","AirCreole","Le port","Rabat",LocalDate.of(2025,4,20),LocalDate.of(2025,4,21)));
        vuelos.add(new Vuelo(7,"KO22","AirHolanda","Amesterdam","Miami",LocalDate.of(2025,2,20),LocalDate.of(2025,2,21)));
        vuelos.add(new Vuelo(8,"LO22","AirAustralia","Adelaide","Barcelona",LocalDate.of(2025,11,20),LocalDate.of(2025,11,21)));
        vuelos.add(new Vuelo(9,"V822","AirUSA","Charlotte","Houston",LocalDate.of(2025,12,20),LocalDate.of(2025,12,21)));
        vuelos.add(new Vuelo(10,"R622","AirCongo","Kinshasa","Paris",LocalDate.of(2025,3,20),LocalDate.of(2025,3,21)));


        String fechaDesdeTexto = (fechaDesde != null) ? fechaDesde.toString() : "sin fecha de inicio";
        String fechaHastaTexto = (fechaHasta != null) ? fechaHasta.toString() : "sin fecha de fin";


        System.out.println("Buscando vuelos disponibles entre " + fechaDesdeTexto + " y " + fechaHastaTexto + ":");

        // Aplicar el filtro de vuelos

        List<Vuelo> vuelosFiltrados = FiltroVuelos.filtrar(vuelos, fechaDesde, fechaHasta);

        // Mostrar resultados

        if (vuelosFiltrados.isEmpty()) {
            System.out.println("No hay vuelos disponibles.");
        } else {
            System.out.println("Vuelos disponibles:");
            vuelosFiltrados.forEach(System.out::println);
        }
    }
}




