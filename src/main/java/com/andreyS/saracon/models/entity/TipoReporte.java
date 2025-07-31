package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tiporeporte")
public class TipoReporte {

    @Id
    @Column(name = "id_tipo_reporte")
    private Integer idTipoReporte;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "tipoReporte")
    @ToString.Exclude
    private List<Reporte> reportes;

}
