package com.alura.forohuboracle.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosLoginUsuario(
    @NotBlank
    String correo,
    @NotBlank
    String clave
) {

}
