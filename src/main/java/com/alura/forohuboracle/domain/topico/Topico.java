package com.alura.forohuboracle.domain.topico;

import java.time.LocalDateTime;

import com.alura.forohuboracle.domain.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fechacreacion")
    private LocalDateTime fecha;
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor")
    private Usuario autor;

    public void actualizarDatos(DatosTopicoActualizado datosTopicoActualizado){
        this.titulo=datosTopicoActualizado.titulo();
        this.mensaje=datosTopicoActualizado.mensaje();
        this.estado="Actualizado";
        this.fecha=LocalDateTime.now();
    }
}
