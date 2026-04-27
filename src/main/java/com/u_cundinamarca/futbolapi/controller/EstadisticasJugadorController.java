package com.u_cundinamarca.futbolapi.controller;

import com.u_cundinamarca.futbolapi.model.EstadisticasJugador;
import com.u_cundinamarca.futbolapi.service.EstadisticasJugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@RequiredArgsConstructor
@Tag(name = "Estadísticas", description = "CRUD de estadísticas de jugadores")
public class EstadisticasJugadorController {

    private final EstadisticasJugadorService estadisticasService;

    @GetMapping
    @Operation(summary = "Listar todas las estadísticas")
    public List<EstadisticasJugador> findAll() { return estadisticasService.findAll(); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estadística por ID")
    public ResponseEntity<EstadisticasJugador> findById(@PathVariable Long id) {
        return ResponseEntity.ok(estadisticasService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear estadística")
    public ResponseEntity<EstadisticasJugador> save(@RequestBody EstadisticasJugador est) {
        return ResponseEntity.ok(estadisticasService.save(est));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estadística")
    public ResponseEntity<EstadisticasJugador> update(@PathVariable Long id, @RequestBody EstadisticasJugador est) {
        return ResponseEntity.ok(estadisticasService.update(id, est));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estadística")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadisticasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}