package com.alura.forohuboracle.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosTopicoActualizado(
    @NotBlank
    String titulo,
    @NotBlank
    String mensaje
) {

}
