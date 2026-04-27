package com.u_cundinamarca.futbolapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "partido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "estadisticas"})
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Long idPartido;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estadio", length = 100)
    private String estadio;

    // Relación hacia equipo local (FK: equipo_local)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Equipo equipoLocal;

    // Relación hacia equipo visitante (FK: equipo_visita)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visita", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Equipo equipoVisita;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visita")
    private Integer golesVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<EstadisticasJugador> estadisticas;
}