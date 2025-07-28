package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tipoentidad")
public class TipoEntidad {
    @Id
    @Column(name = "id_tipo_entidad")
    private Integer idTipoEntidad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoEntidad")
    private List<Entidad> entidades;

}