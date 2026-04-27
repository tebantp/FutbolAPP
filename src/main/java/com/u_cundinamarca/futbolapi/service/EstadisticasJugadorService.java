package com.u_cundinamarca.futbolapi.service;

import com.u_cundinamarca.futbolapi.model.EstadisticasJugador;
import com.u_cundinamarca.futbolapi.repository.EstadisticasJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadisticasJugadorService {

    private final EstadisticasJugadorRepository estadisticasRepository;

    public List<EstadisticasJugador> findAll() { return estadisticasRepository.findAll(); }

    public EstadisticasJugador findById(Long id) {
        return estadisticasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estadística no encontrada: " + id));
    }

    public EstadisticasJugador save(EstadisticasJugador est) { return estadisticasRepository.save(est); }

    public EstadisticasJugador update(Long id, EstadisticasJugador est) {
        estadisticasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estadística no encontrada: " + id));
        est.setIdEstadistica(id);
        return estadisticasRepository.save(est);
    }

    public void delete(Long id) { estadisticasRepository.deleteById(id); }
}