package com.andreyS.saracon.models.entity;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties({ "tipoEntidad" })
    private Entidad entidadReporta;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reporte", nullable = false)
    @ToString.Exclude
    @JsonIgnoreProperties({ "reportes" })
    private TipoReporte tipoReporte;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

}