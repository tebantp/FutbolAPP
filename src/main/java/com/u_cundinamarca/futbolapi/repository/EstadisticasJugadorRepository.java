package com.u_cundinamarca.futbolapi.repository;

import com.u_cundinamarca.futbolapi.model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {
}