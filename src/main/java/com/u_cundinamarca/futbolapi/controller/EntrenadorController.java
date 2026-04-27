package com.u_cundinamarca.futbolapi.controller;

import com.u_cundinamarca.futbolapi.model.Entrenador;
import com.u_cundinamarca.futbolapi.service.EntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
@Tag(name = "Entrenadores", description = "CRUD de entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @GetMapping
    @Operation(summary = "Listar todos los entrenadores")
    public List<Entrenador> findAll() { return entrenadorService.findAll(); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener entrenador por ID")
    public ResponseEntity<Entrenador> findById(@PathVariable Long id) {
        return ResponseEntity.ok(entrenadorService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear entrenador")
    public ResponseEntity<Entrenador> save(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.save(entrenador));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar entrenador")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.update(id, entrenador));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar entrenador")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entrenadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}