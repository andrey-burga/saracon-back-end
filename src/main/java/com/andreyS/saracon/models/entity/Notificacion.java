package com.andreyS.saracon.models.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Long idNotificacion;

    // Notificacion.java
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_entidad", nullable = false)
    @JsonBackReference("entidad-notificacion")
    private Entidad entidad;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    @Column(name = "fecha_notificacion")
    private LocalDateTime fechaNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_notificacion", nullable = false)
    @JsonBackReference("tipo-notificacion")
    private TipoNotificacion tipoNotificacion;

    @Column(name = "fecha_vencimiento")
    private LocalDateTime fechaVencimiento;

    @PrePersist
    protected void onCreate() {
        this.fechaNotificacion = LocalDateTime.now();
    }

}
