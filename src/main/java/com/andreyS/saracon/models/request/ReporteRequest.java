package com.andreyS.saracon.models.request;

import java.time.LocalDateTime;

 
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteRequest {
    private String mensaje;
    private String tipoNotificacion;
    private LocalDateTime fechaVencimiento;
    private String titulo;
    private String emailEntidad; // 👈 más simple: solo email en vez de todo Entidad
}
