package com.u_cundinamarca.futbolapi.repository;

import com.u_cundinamarca.futbolapi.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}