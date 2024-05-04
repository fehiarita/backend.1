package com.postgresql.api.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comentarios")
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_comentario;

    //@ManyToOne
    //@JoinColumn(name = "id_postagem")
    // private Postagem id_postagem - A ser implementado a Entidade postagem

    @Column
    private String conteudo;

    @Column
    private LocalDateTime data_hora;

    @Column
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

}
