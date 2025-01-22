package com.alura.forohuboracle.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.NotBlank;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    UserDetails findByCorreo(String subject);

    boolean existsByCorreo(@NotBlank String correo);

}
