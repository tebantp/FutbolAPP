package com.u_cundinamarca.futbolapi.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "entrenador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrenador")
    private Long idEntrenador;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Equipo equipo;
}