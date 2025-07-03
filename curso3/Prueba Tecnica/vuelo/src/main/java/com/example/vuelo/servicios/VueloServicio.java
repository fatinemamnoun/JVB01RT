package com.example.vuelo.servicios;

import com.example.vuelo.dtos.VueloDTO;
import com.example.vuelo.models.Vuelo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service public class VueloServicio implements IVueloServicio {
    private List<Vuelo> vuelos;

    public VueloServicio() {
        this.vuelos = new ArrayList<>();
        vuelos.add(new Vuelo(1, "k122", "AirKorea", "Seoul", "Madrid", LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 21)));
        vuelos.add(new Vuelo(2, "D122", "AirNippon", "Tokyo", "Hanoi", LocalDate.of(2025, 6, 20), LocalDate.of(2025, 6, 21)));
        vuelos.add(new Vuelo(3, "F122", "AirChina", "Shangahai", "Bangkok", LocalDate.of(2025, 9, 20), LocalDate.of(2025, 9, 21)));
        vuelos.add(new Vuelo(4, "D122", "AirColombia", "Bogota", "Osaka", LocalDate.of(2025, 7, 20), LocalDate.of(2025, 7, 21)));
        vuelos.add(new Vuelo(5, "D255", "AirSaudia", "Jeddah", "Seoul", LocalDate.of(2025, 8, 20), LocalDate.of(2025, 8, 21)));
        vuelos.add(new Vuelo(6, "C133", "AirCreole", "Le port", "Rabat", LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 21)));
        vuelos.add(new Vuelo(7, "KO22", "AirHolanda", "Amesterdam", "Miami", LocalDate.of(2025, 2, 20), LocalDate.of(2025, 2, 21)));
        vuelos.add(new Vuelo(8, "LO22", "AirAustralia", "Adelaide", "Barcelona", LocalDate.of(2025, 11, 20), LocalDate.of(2025, 11, 21)));
        vuelos.add(new Vuelo(9, "V822", "AirUSA", "Charlotte", "Houston", LocalDate.of(2025, 12, 20), LocalDate.of(2025, 12, 21)));
        vuelos.add(new Vuelo(10, "R622", "AirCongo", "Kinshasa", "Paris", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 21)));
    }

    @Override
    public List<VueloDTO> obtenerVuelo(
            String nombreVuelo,
            String empresa,
            String lugarSalida,
            String lugarLlegada,
            LocalDate fechaSalida,
            LocalDate fechaLlegada
    ) {
        return vuelos.stream()
                .filter(v -> nombreVuelo == null || v.getNombreVuelo().equalsIgnoreCase(nombreVuelo))
                .filter(v -> empresa == null || v.getEmpresa().equalsIgnoreCase(empresa))
                .filter(v -> lugarSalida == null || v.getLugarSalida().equalsIgnoreCase(lugarSalida))
                .filter(v -> lugarLlegada == null || v.getLugarLlegada().equalsIgnoreCase(lugarLlegada))
                .filter(v -> fechaSalida == null || v.getFechaSalida().isEqual(fechaSalida))
                .filter(v -> fechaLlegada == null || v.getFechaLlegada().isEqual(fechaLlegada))
                .map(this::convertirHaciaDTO)
                .toList();
    }

    @Override
    public VueloDTO obtenerVueloPorId(int id) {
        return vuelos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .map(this::convertirHaciaDTO)
                .orElse(null);
    }

    @Override
    public VueloDTO crear(VueloDTO v) {
        int nuevoId = vuelos.stream()
                .mapToInt(Vuelo::getId)
                .max()
                .orElse(0) + 1;

        Vuelo nuevo = convertirHaciaOBJ(v);
        nuevo.setId(nuevoId);
        vuelos.add(nuevo);

        return convertirHaciaDTO(nuevo);
    }

    @Override
    public List<Vuelo> actualizar(int id, Vuelo nuevoVuelo) {
        Vuelo actualizado = modificar(id, nuevoVuelo);
        return actualizado != null ? vuelos : null;
    }

    @Override
    public Vuelo modificar(int id, Vuelo vueloParaModificar) {
        for (int i = 0; i < vuelos.size(); i++) {
            if (vuelos.get(i).getId() == id) {
                vueloParaModificar.setId(id);
                vuelos.set(i, vueloParaModificar);
                return vueloParaModificar;
            }
        }
        return null;
    }

    @Override
    public ResponseEntity<?> eliminar(int id) {
        boolean eliminado = vuelos.removeIf(v -> v.getId() == id);
        return eliminado ? ResponseEntity.ok("Eliminado correctamente") : ResponseEntity.notFound().build();

    }

    @Override
    public Vuelo encontrarVuelo(int id) {
        return vuelos.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vuelo> eliminarVuelo() {
        vuelos.clear();
        return vuelos;
    }

    @Override
    public VueloDTO convertirHaciaDTO(Vuelo v) {
        return new VueloDTO(
                v.getId(),
                v.getNombreVuelo(),
                v.getEmpresa(),
                v.getLugarSalida(),
                v.getLugarLlegada(),
                v.getFechaSalida(),
                v.getFechaLlegada()
        );
    }

    @Override
    public Vuelo convertirHaciaOBJ(VueloDTO v) {
        return new Vuelo(
                v.getId(), // Se puede sobreescribir con el nuevo ID en `crear`
                v.getNombreVuelo(),
                v.getEmpresa(),
                v.getLugarSalida(),
                v.getLugarLlegada(),
                v.getFechaSalida(),
                v.getFechaLlegada()
        );
    }
}











