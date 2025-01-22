package com.alura.forohuboracle.domain.usuario;

public record DatosMostrarUsuario(
    String nombre,
    String correo
) {
    public DatosMostrarUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getCorreo());
    }
}
