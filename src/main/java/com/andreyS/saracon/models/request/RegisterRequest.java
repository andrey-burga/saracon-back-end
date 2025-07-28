package com.andreyS.saracon.models.request;

import com.andreyS.saracon.models.entity.Empresa;
import com.andreyS.saracon.models.entity.Entidad;
import com.andreyS.saracon.models.entity.PersonaNatural;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private Entidad entidad;
    private PersonaNatural personaNatural;
    private Empresa empresa;

}
