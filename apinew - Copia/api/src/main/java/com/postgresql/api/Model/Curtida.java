package com.postgresql.api.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "curtidas_comentario")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurtida;

    @ManyToOne
    @JoinColumn(name = "idComentarios")
    private Comentarios comentarios;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
    @id
    @generatedValue(strategy = GenerationType.IDENTITY)
    public data horario_curtida;


}