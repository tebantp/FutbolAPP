package com.u_cundinamarca.futbolapi.repository;

import com.u_cundinamarca.futbolapi.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // CONSULTA NATIVA 1: Todos los jugadores de un equipo específico
    @Query(value = """
            SELECT j.id_jugador, j.nombre, j.posicion, j.dorsal,
                   j.fecha_nac, j.nacionalidad, j.id_equipo
            FROM jugador j
            WHERE j.id_equipo = :idEquipo
            """, nativeQuery = true)
    List<Object[]> findJugadoresByEquipo(@Param("idEquipo") Long idEquipo);

    // CONSULTA NATIVA 2: Jugadores que han marcado más de X goles (sumando todas sus estadísticas)
    @Query(value = """
            SELECT j.id_jugador, j.nombre, j.posicion, j.dorsal,
                   j.nacionalidad, SUM(e.goles) AS total_goles
            FROM jugador j
            JOIN estadisticas_jugador e ON j.id_jugador = e.id_jugador
            GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.nacionalidad
            HAVING SUM(e.goles) > :minGoles
            ORDER BY total_goles DESC
            """, nativeQuery = true)
    List<Object[]> findJugadoresConMasDeXGoles(@Param("minGoles") Integer minGoles);
}