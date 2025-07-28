package com.andreyS.saracon.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Long idReporte;

    @ManyToOne
    @JoinColumn(name = "id_entidad", nullable = false)
    @ToString.Exclude
    private Entidad entidadReporta;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reporte", nullable = false)
    @ToString.Exclude
    private TipoReporte tipoReporte;

    @ManyToOne
    @JoinColumn(name = "id_entidad_destino")
    @ToString.Exclude
    private Entidad entidadDestino;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_reporte")
    private LocalDateTime fechaReporte;

    @Column(name = "estado")
    private String estado;

}