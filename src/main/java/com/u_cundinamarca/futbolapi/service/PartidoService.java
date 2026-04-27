package com.u_cundinamarca.futbolapi.service;

import com.u_cundinamarca.futbolapi.model.Partido;
import com.u_cundinamarca.futbolapi.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidoService {

    private final PartidoRepository partidoRepository;

    public List<Partido> findAll() { return partidoRepository.findAll(); }

    public Partido findById(Long id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado: " + id));
    }

    public Partido save(Partido partido) { return partidoRepository.save(partido); }

    public Partido update(Long id, Partido partido) {
        partidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado: " + id));
        partido.setIdPartido(id);
        return partidoRepository.save(partido);
    }

    public void delete(Long id) { partidoRepository.deleteById(id); }

    // Consulta nativa 3
    public List<Object[]> findTotalGoles(Long idEquipo) {
        return partidoRepository.findTotalGolesByEquipo(idEquipo);
    }

    // Consulta nativa 4
    public List<Object[]> findResultados() {
        return partidoRepository.findResultadosPartidos();
    }
}