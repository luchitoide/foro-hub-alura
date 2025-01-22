package com.alura.forohuboracle.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosTopico(
    @NotNull
    String titulo,
    @NotNull
    String mensaje,
    @NotNull
    Long autor
) {

}
