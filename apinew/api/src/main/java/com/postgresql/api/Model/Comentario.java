package com.postgresql.api.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id_comentario;

    @OneToOne
    @Column(nullable = false, unique = true)
    private Usuario id_usuario;

    @Column()
    private LocalDate datahora;
}
