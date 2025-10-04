package com.andreyS.saracon.models.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Personanatural")
public class PersonaNatural {

    @Id
    @Column(name = "id_entidad")
    private Long idEntidad;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_entidad")
    @ToString.Exclude

    private Entidad entidad;

    @Column(name = "documento_identidad", nullable = false, unique = true)
    private String documentoIdentidad;

    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumento;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "genero", length = 1)
    private String genero;

}