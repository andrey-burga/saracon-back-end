package com.andreyS.saracon.models.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reporte")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Long idReporte;

    // Report.java
    @ManyToOne
    @JoinColumn(name = "id_entidad", nullable = false)
    @JsonBackReference("entidad-reporte")
    private Entidad entidadReporta;

    @ManyToOne
    @JoinColumn(name = "id_tipo_reporte", nullable = false)
    @JsonBackReference("tipo-reporte")
    private TipoReporte tipoReporte;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

}