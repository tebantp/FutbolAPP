package com.u_cundinamarca.futbolapi.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estadisticas_jugador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Long idEstadistica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Partido partido;

    @Column(name = "minutos_jugados")
    private Integer minutosJugados;

    @Column(name = "goles")
    private Integer goles;

    @Column(name = "asistencias")
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas")
    private Integer tarjetasAmarillas;

    @Column(name = "tarjetas_rojas")
    private Integer tarjetasRojas;
}