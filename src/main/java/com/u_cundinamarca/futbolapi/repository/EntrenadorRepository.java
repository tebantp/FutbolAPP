package com.u_cundinamarca.futbolapi.repository;

import com.u_cundinamarca.futbolapi.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}