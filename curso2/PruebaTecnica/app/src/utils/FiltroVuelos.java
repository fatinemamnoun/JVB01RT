package utils;


import entities.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FiltroVuelos {


    public static List<Vuelo> filtrar(List<Vuelo> vuelos, LocalDate fechaDesde, LocalDate fechaHasta) {
        return vuelos.stream()
                .filter(v -> {
                    // Filtrar si la fecha está diferente del ano 2025
                    if (v.getFechaInicio().getYear() != 2025 || v.getFechaFinal().getYear() != 2025) {
                        return false;
                    }
                    return (fechaDesde == null || !v.getFechaInicio().isBefore(fechaDesde)) &&
                            (fechaHasta == null || !v.getFechaInicio().isAfter(fechaHasta));
                })
                .filter(v -> {
                    if (fechaDesde == null && fechaHasta == null) {
                        return true; // Si no se envían fechas, devolver todos los vuelos
                    } else if (fechaDesde == null) {
                        return !v.getFechaInicio().isAfter(fechaHasta); // Si solo hay fechaHasta, mostrar vuelos hasta esa fecha
                    } else if (fechaHasta == null) {
                        return !v.getFechaInicio().isBefore(fechaDesde); // Si solo hay fechaDesde, mostrar vuelos desde esa fecha
                    } else {
                        return !v.getFechaInicio().isBefore(fechaDesde) && !v.getFechaInicio().isAfter(fechaHasta); // Si ambas fechas están definidas, devolver vuelos en el rango
                    }
                })
                .sorted((v1, v2) -> v1.getFechaInicio().compareTo(v2.getFechaInicio()))
                .collect(Collectors.toList());





    }

}