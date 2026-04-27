package com.u_cundinamarca.futbolapi.service;

import com.u_cundinamarca.futbolapi.model.Jugador;
import com.u_cundinamarca.futbolapi.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public List<Jugador> findAll() { return jugadorRepository.findAll(); }

    public Jugador findById(Long id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado: " + id));
    }

    public Jugador save(Jugador jugador) { return jugadorRepository.save(jugador); }

    public Jugador update(Long id, Jugador jugador) {
        jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado: " + id));
        jugador.setIdJugador(id);
        return jugadorRepository.save(jugador);
    }

    public void delete(Long id) { jugadorRepository.deleteById(id); }

    // Consulta nativa 1
    public List<Object[]> findByEquipo(Long idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }

    // Consulta nativa 2
    public List<Object[]> findConMasDeXGoles(Integer minGoles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(minGoles);
    }
}