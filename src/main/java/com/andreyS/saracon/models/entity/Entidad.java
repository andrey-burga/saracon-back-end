package com.andreyS.saracon.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entidad")
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private Long idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_entidad", nullable = false)
    @ToString.Exclude
    private TipoEntidad tipoEntidad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private PersonaNatural personaNatural;

    @OneToOne(mappedBy = "entidad")
    @ToString.Exclude
    private Empresa empresa;

    @OneToMany(mappedBy = "entidadReporta")
    @ToString.Exclude
    private List<Reporte> reportesEnviados;

    @OneToMany(mappedBy = "entidadDestino")
    @ToString.Exclude
    private List<Reporte> reportesRecibidos;

    @OneToMany(mappedBy = "entidad")
    @ToString.Exclude
    private List<Notificacion> notificaciones;

    @Column(name = "password", nullable = false)
    private String password;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date();
    }
}
