package com.example.vuelo.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FechaUtils {

    public static boolean fechasValidas(LocalDate salida, LocalDate llegada) {
        return salida != null && llegada != null && !salida.isAfter(llegada);
    }

    public static long calcularDuracionEnDias(LocalDate salida, LocalDate llegada) {
        if (salida != null && llegada != null) {
            return ChronoUnit.DAYS.between(salida, llegada);
        }
        return 0;
    }
}
