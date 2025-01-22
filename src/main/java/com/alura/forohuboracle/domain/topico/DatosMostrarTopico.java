package com.alura.forohuboracle.domain.topico;

import java.time.LocalDateTime;

public record DatosMostrarTopico(
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    String estado,
    String autor
) {
    public DatosMostrarTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getEstado(), topico.getAutor().getNombre());
    }
}
