package com.andreyS.saracon.models.entity;


import java.util.Date;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "empresa")
public class Empresa  {

    @Id
    @Column(name = "id_entidad")
    private Long idEntidad;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_entidad")
    @ToString.Exclude
    private Entidad entidad;

    @Column(name = "nit", nullable = false, unique = true)
    private String nit;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Column(name = "sector")
    private String sector;

    @Column(name = "fecha_constitucion")
    @Temporal(TemporalType.DATE)
    private Date fechaConstitucion;

}