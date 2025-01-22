package com.alura.forohuboracle.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.forohuboracle.domain.topico.TopicoService;
import com.alura.forohuboracle.domain.topico.DatosMostrarTopico;
import com.alura.forohuboracle.domain.topico.DatosTopicoActualizado;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.alura.forohuboracle.domain.topico.DatosTopico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@SecurityRequirement(name = "bearer token")
@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<DatosTopico> registrarNuevoTopico(@RequestBody @Valid DatosTopico datos) {
        URI uri = service.RegistrarNuevoTopico(datos);
        return ResponseEntity.created(uri).body(datos); 
    }
    
    @GetMapping
    public ResponseEntity<Page<DatosMostrarTopico>> mostrarTodosLosTopicos(@PageableDefault(page = 0,size = 10,sort = "fecha", direction = Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.BuscarTodosLostopicos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosMostrarTopico> mostrarUnTopico(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarUnTopicoPorId(id));
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosMostrarTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosTopicoActualizado datos) {
        return ResponseEntity.ok(service.actualizarTopico(id, datos));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity borrarTopico(@PathVariable Long id){
        service.borrarTopico(id);
        return ResponseEntity.ok().build();
    }
    
}
