package com.u_cundinamarca.futbolapi.repository;

import com.u_cundinamarca.futbolapi.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    // CONSULTA NATIVA 3: Total de goles de un equipo en todos sus partidos (local + visitante)
    @Query(value = """
            SELECT
                e.nombre AS equipo,
                SUM(CASE WHEN p.equipo_local = :idEquipo THEN p.goles_local ELSE 0 END) +
                SUM(CASE WHEN p.equipo_visita = :idEquipo THEN p.goles_visita ELSE 0 END)
                AS total_goles
            FROM partido p
            JOIN equipo e ON e.id_equipo = :idEquipo
            WHERE p.equipo_local = :idEquipo OR p.equipo_visita = :idEquipo
            GROUP BY e.nombre
            """, nativeQuery = true)
    List<Object[]> findTotalGolesByEquipo(@Param("idEquipo") Long idEquipo);

    // CONSULTA NATIVA 4: Resultados de todos los partidos con nombres de equipos
    @Query(value = """
            SELECT
                p.id_partido,
                p.fecha,
                p.estadio,
                el.nombre AS equipo_local,
                ev.nombre AS equipo_visitante,
                p.goles_local,
                p.goles_visita
            FROM partido p
            JOIN equipo el ON p.equipo_local  = el.id_equipo
            JOIN equipo ev ON p.equipo_visita = ev.id_equipo
            ORDER BY p.fecha DESC
            """, nativeQuery = true)
    List<Object[]> findResultadosPartidos();
}