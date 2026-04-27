package com.u_cundinamarca.futbolapi.controller;

import com.u_cundinamarca.futbolapi.model.Partido;
import com.u_cundinamarca.futbolapi.service.PartidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
@Tag(name = "Partidos", description = "CRUD de partidos y consultas nativas")
public class PartidoController {

    private final PartidoService partidoService;

    @GetMapping
    @Operation(summary = "Listar todos los partidos")
    public List<Partido> findAll() { return partidoService.findAll(); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener partido por ID")
    public ResponseEntity<Partido> findById(@PathVariable Long id) {
        return ResponseEntity.ok(partidoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear partido")
    public ResponseEntity<Partido> save(@RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.save(partido));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar partido")
    public ResponseEntity<Partido> update(@PathVariable Long id, @RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.update(id, partido));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar partido")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // CONSULTA NATIVA 3
    @GetMapping("/goles/equipo/{idEquipo}")
    @Operation(summary = "Total de goles de un equipo en todos sus partidos")
    public ResponseEntity<List<Object[]>> findTotalGoles(@PathVariable Long idEquipo) {
        return ResponseEntity.ok(partidoService.findTotalGoles(idEquipo));
    }

    // CONSULTA NATIVA 4
    @GetMapping("/resultados")
    @Operation(summary = "Resultados de todos los partidos con nombres de equipos")
    public ResponseEntity<List<Object[]>> findResultados() {
        return ResponseEntity.ok(partidoService.findResultados());
    }
}