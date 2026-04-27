package com.u_cundinamarca.futbolapi.controller;

import com.u_cundinamarca.futbolapi.model.Equipo;
import com.u_cundinamarca.futbolapi.service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
@Tag(name = "Equipos", description = "CRUD de equipos")
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping
    @Operation(summary = "Listar todos los equipos")
    public List<Equipo> findAll() { return equipoService.findAll(); }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener equipo por ID")
    public ResponseEntity<Equipo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear equipo")
    public ResponseEntity<Equipo> save(@RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoService.save(equipo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar equipo")
    public ResponseEntity<Equipo> update(@PathVariable Long id, @RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoService.update(id, equipo));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar equipo")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}