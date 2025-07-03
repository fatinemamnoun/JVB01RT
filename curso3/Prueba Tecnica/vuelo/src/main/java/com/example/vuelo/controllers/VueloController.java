package com.example.vuelo.controllers;

import com.example.vuelo.dtos.VueloDTO;

import com.example.vuelo.models.Vuelo;
import com.example.vuelo.servicios.IVueloServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vuelos")

public class VueloController {
    private final IVueloServicio servicio;

    public VueloController(IVueloServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/vuelo")

    public ResponseEntity<List<VueloDTO>> obtenerVuelo(
            @RequestParam(required = false) String nombreVuelo,
            @RequestParam(required = false) String empresa,
            @RequestParam(required = false) String lugarSalida,
            @RequestParam(required = false) String lugarLlegada,
            @RequestParam(required = false) LocalDate fechaSalida,
            @RequestParam(required = false) LocalDate fechaLlegada,
            @RequestParam(required = false) String ordenarPor
    ) {
        List<VueloDTO> vuelos = servicio.obtenerVuelo(
                nombreVuelo, empresa, lugarSalida, lugarLlegada, fechaSalida, fechaLlegada
        );
        // ordenar aquí
        return ResponseEntity.ok(vuelos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> obtenerVueloPorId(@PathVariable int id) {
        VueloDTO vuelo = servicio.obtenerVueloPorId(id);
        return ResponseEntity.ok(vuelo);
    }

    // ✅ POST /vuelos → Crear un nuevo vuelo
    @PostMapping
    public ResponseEntity<VueloDTO> crearVuelo(@RequestBody VueloDTO vueloDTO) {
        VueloDTO creado = servicio.crear(vueloDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // ✅ PUT /vuelos/{id} → Actualizar un vuelo existente
    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> actualizarVuelo(@PathVariable int id, @RequestBody VueloDTO vueloDTO) {
        Vuelo actualizado = servicio.modificar(id, servicio.convertirHaciaOBJ(vueloDTO));
        return ResponseEntity.ok(servicio.convertirHaciaDTO(actualizado));
    }

    // ✅ DELETE /vuelos/{id} → Eliminar un vuelo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVuelo(@PathVariable int id) {
        return servicio.eliminar(id);
    }
}