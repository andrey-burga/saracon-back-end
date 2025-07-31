package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entidad")
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_entidad", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private TipoEntidad tipoEntidad;

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @JsonIgnore
    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private PersonaNatural personaNatural;

    @JsonIgnore
    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "entidadReporta")
    @ToString.Exclude
    private List<Reporte> reportesEnviados;

    @JsonIgnore
    @OneToMany(mappedBy = "entidad")
    @ToString.Exclude
    private List<Notificacion> notificaciones;

    @JsonIgnore
    private String password;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date();
    }
}
