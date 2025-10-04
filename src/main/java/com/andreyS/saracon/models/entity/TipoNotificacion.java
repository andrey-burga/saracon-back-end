package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tiponotificacion")
public class TipoNotificacion {

    @Id
    @Column(name = "id_tipo_notificacion")
    private Integer idTipoNotificacion;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoNotificacion")
    @JsonManagedReference("tipo-notificacion")
    private List<Notificacion> notificaciones;

}
