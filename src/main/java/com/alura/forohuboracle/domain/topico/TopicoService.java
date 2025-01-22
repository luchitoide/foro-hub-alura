package com.alura.forohuboracle.domain.topico;

import java.net.URI;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.forohuboracle.domain.usuario.Usuario;
import com.alura.forohuboracle.domain.usuario.UsuarioRepository;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public URI RegistrarNuevoTopico(DatosTopico datosTopico){
        if (!usuarioRepository.findById(datosTopico.autor()).isPresent()) {
            throw new RuntimeException("No se encontro al usuario");
        }
        Usuario usuario = usuarioRepository.findById(datosTopico.autor()).get();
        Topico topico = new Topico(null, datosTopico.titulo(), datosTopico.mensaje(), LocalDateTime.now(), "Creado", usuario);
        topicoRepository.save(topico);
        URI uri = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return uri;
    }

    public Page<DatosMostrarTopico> BuscarTodosLostopicos(Pageable pageable){
        Page<DatosMostrarTopico> topicos = topicoRepository.findAll(pageable).map(DatosMostrarTopico::new);
        return topicos;
    }

    public DatosMostrarTopico buscarUnTopicoPorId(Long id){
        if (!topicoRepository.findById(id).isPresent()) {
            throw new RuntimeException("No se encontro el topico");
        }
        DatosMostrarTopico dato = new DatosMostrarTopico(topicoRepository.findById(id).get());
        return dato;
    }

    public DatosMostrarTopico actualizarTopico(Long id, DatosTopicoActualizado datosTopicoActualizado){
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("No se encontro el topico");
        }
        Topico topicoActualizado = topicoRepository.findById(id).get();
        topicoActualizado.actualizarDatos(datosTopicoActualizado);
        return new DatosMostrarTopico(topicoActualizado);
    }

    public void borrarTopico(Long id){
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("No se encontro el topico");
        }
        topicoRepository.deleteById(id);
    }
}
