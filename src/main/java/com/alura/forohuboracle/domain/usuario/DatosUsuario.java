package com.alura.forohuboracle.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
    @NotBlank
    String nombre,
    @NotBlank
    String correo,
    @NotBlank
    String clave
) {

}
