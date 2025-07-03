package com.example.vuelo.servicios;

import com.example.vuelo.dtos.VueloDTO;
import com.example.vuelo.models.Vuelo;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IVueloServicio {
//  Búsqueda con filtros
  List<VueloDTO> obtenerVuelo ( String nombreVuelo ,String empresa,String lugarSalida,String lugarLlegada, LocalDate fechaSalida, LocalDate fechaLlegada);

  // Búsqueda por ID
  VueloDTO obtenerVueloPorId (int id);

  // Crear vuelo
  VueloDTO crear(VueloDTO v);


  // Actualizar vuelo y devolver lista actualizada
    List<Vuelo> actualizar(int id, Vuelo nuevoVuelo);

  // Modificar vuelo completo (por objeto)
    Vuelo modificar(int id, Vuelo vueloParaModificar);

  // Eliminar vuelo por ID
    ResponseEntity<?> eliminar(int id);

  // Buscar vuelo como objeto (uso interno)
    Vuelo encontrarVuelo(int id);


  // Eliminar vuelo
    List<Vuelo> eliminarVuelo();

  //  Conversión entre DTO y entidad
    VueloDTO convertirHaciaDTO(Vuelo v);

    Vuelo convertirHaciaOBJ(VueloDTO v);

}
