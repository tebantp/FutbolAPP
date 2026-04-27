package com.u_cundinamarca.futbolapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jugador")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "estadisticas"})
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "posicion", length = 50)
    private String posicion;

    @Column(name = "dorsal")
    private Integer dorsal;

    @Column(name = "fecha_nac")
    private LocalDate fechaNac;

    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<EstadisticasJugador> estadisticas;
}