package com.u_cundinamarca.futbolapi.service;

import com.u_cundinamarca.futbolapi.model.Entrenador;
import com.u_cundinamarca.futbolapi.repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public List<Entrenador> findAll() { return entrenadorRepository.findAll(); }

    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + id));
    }

    public Entrenador save(Entrenador entrenador) { return entrenadorRepository.save(entrenador); }

    public Entrenador update(Long id, Entrenador entrenador) {
        entrenadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado: " + id));
        entrenador.setIdEntrenador(id);
        return entrenadorRepository.save(entrenador);
    }

    public void delete(Long id) { entrenadorRepository.deleteById(id); }
}