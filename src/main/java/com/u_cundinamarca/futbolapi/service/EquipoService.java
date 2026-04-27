package com.u_cundinamarca.futbolapi.service;

import com.u_cundinamarca.futbolapi.model.Equipo;
import com.u_cundinamarca.futbolapi.repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public List<Equipo> findAll() { return equipoRepository.findAll(); }

    public Equipo findById(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado: " + id));
    }

    public Equipo save(Equipo equipo) { return equipoRepository.save(equipo); }

    public Equipo update(Long id, Equipo equipo) {
        equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado: " + id));
        equipo.setIdEquipo(id);
        return equipoRepository.save(equipo);
    }

    public void delete(Long id) { equipoRepository.deleteById(id); }
}