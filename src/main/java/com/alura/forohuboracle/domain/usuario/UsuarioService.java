package com.alura.forohuboracle.domain.usuario;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public URI registrarUsuario(DatosUsuario datosUsuario){
        if (usuarioRepository.existsByCorreo(datosUsuario.correo())) {
            throw new RuntimeException("Ya existe este usuario");
        }
        Usuario usuario = new Usuario(null, datosUsuario.nombre(), datosUsuario.correo(), hashPassword(datosUsuario.clave()));
        usuarioRepository.save(usuario);
        URI uri = UriComponentsBuilder.fromPath("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return uri;
    }

    private String hashPassword(String clave) {
		String salt = BCrypt.gensalt(12);
		String hashed_password = BCrypt.hashpw(clave, salt);

		return(hashed_password);
	}

    public Page<DatosMostrarUsuario> buscarTodosLosUsuarios(Pageable pageable){
        Page<DatosMostrarUsuario> usuarios = usuarioRepository.findAll(pageable).map(DatosMostrarUsuario::new);
        return usuarios;
    }

    public DatosMostrarUsuario buscarUnUsuario(Long id){
        if (!usuarioRepository.findById(id).isPresent()) {
            throw new RuntimeException("No se encontro al usuario");
        }
        DatosMostrarUsuario usuario = new DatosMostrarUsuario(usuarioRepository.findById(id).get());
        return usuario;
    }
}
