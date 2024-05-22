package com.postgresql.api.Model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_postagem;

    @Column(nullable = false)
    private String conteudo;

    @Column
    private String imagemUrl;

    @OneToMany
    @Column(nullable = false)
    private Usuario id_usuario;

    @Column(nullable = false)
    private LocalDateTime dataHoraPostagem;
    // @ManyToOne
    // @Column(nullable = false)
    // private Curtida id_curtida;


}
