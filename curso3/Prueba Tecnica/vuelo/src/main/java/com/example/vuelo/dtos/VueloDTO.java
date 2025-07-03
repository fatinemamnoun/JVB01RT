package com.example.vuelo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VueloDTO {
    @JsonProperty("vueloID")
    private int id;
    @JsonProperty("nombreVuelo")
    private String nombreVuelo;
    @JsonProperty("empresa")
    private String empresa;
    @JsonProperty("lugarSalida")
    private String lugarSalida;
    @JsonProperty("lugarLlegada")
    private String lugarLlegada;
    @JsonProperty("fechaSalida")
    private LocalDate fechaSalida;
    @JsonProperty("fechaLlegada")
    private LocalDate fechaLlegada;
}
