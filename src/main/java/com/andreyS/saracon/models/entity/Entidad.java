package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private TipoEntidad tipoEntidad;

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private PersonaNatural personaNatural;

    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private Empresa empresa;

    // Entidad.java
    @OneToMany(mappedBy = "entidadReporta")
    @JsonManagedReference("entidad-reporte")
    private List<Report> reportesEnviados;

    // Entidad.java
    @OneToMany(mappedBy = "entidad")
    @JsonManagedReference("entidad-notificacion")
    private List<Notificacion> notificaciones;

    private String password;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date();
    }
}
