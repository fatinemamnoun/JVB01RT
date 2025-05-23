package utils;
import entities.Vuelo;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class FiltroVuelos {


    public static List<Vuelo> filtrar(List<Vuelo> vuelos, LocalDate fechaDesde, LocalDate fechaHasta) {
        return vuelos.stream()
                .filter(v -> (fechaDesde == null && fechaHasta == null) || // Si ambas fechas son null, no filtrar
                (fechaDesde == null || !v.getFechaInicio().isBefore(fechaDesde)) &&
                        (fechaHasta == null || !v.getFechaInicio().isAfter(fechaHasta)))
                .sorted(java.util.Comparator.comparing(Vuelo::getFechaInicio))
                .sorted(Comparator.comparingInt(Vuelo::getId))//aniade este sorted to ordernar los vuelos con id cuando no pongo filtro
                .collect(Collectors.toList());
    }
}