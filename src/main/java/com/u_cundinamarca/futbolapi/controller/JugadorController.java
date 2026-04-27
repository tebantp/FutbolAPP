package com.u_cundinamarca.futbolapi.controller;

import com.u_cundinamarca.futbolapi.model.Jugador;
import com.u_cundinamarca.futbolapi.service.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
@Tag(name = "Jugadores", description = "CRUD de jugadores y consultas nativas")
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    @Operation(summary = "Listar todos los jugadores")
    public List<Jugador> findAll() { return jugadorService.findAll(); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener jugador por ID")
    public ResponseEntity<Jugador> findById(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear jugador")
    public ResponseEntity<Jugador> save(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.save(jugador));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar jugador")
    public ResponseEntity<Jugador> update(@PathVariable Long id, @RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.update(id, jugador));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar jugador")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jugadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // CONSULTA NATIVA 1
    @GetMapping("/equipo/{idEquipo}")
    @Operation(summary = "Jugadores de un equipo específico")
    public ResponseEntity<List<Object[]>> findByEquipo(@PathVariable Long idEquipo) {
        return ResponseEntity.ok(jugadorService.findByEquipo(idEquipo));
    }

    // CONSULTA NATIVA 2
    @GetMapping("/goles")
    @Operation(summary = "Jugadores con más de X goles")
    public ResponseEntity<List<Object[]>> findConMasDeXGoles(@RequestParam Integer minGoles) {
        return ResponseEntity.ok(jugadorService.findConMasDeXGoles(minGoles));
    }
}