package com.postgresql.api.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partida;

    @Column(nullable = false)
    private LocalDate datahora_partida;

    @ManyToOne
    @JoinColumn(name = "jogador1_id",nullable = false)
    private Usuario jogador1;

    @ManyToOne
    @JoinColumn(name = "jogador2_id", nullable = false)
    private Usuario jogador2;

    @ManyToOne
    @JoinColumn(name = "ganhador_id", nullable = true)
    private Usuario ganhador;

    @Column(nullable = true)
    private Integer score;

    @OneToMany
    @Column(nullable = false)
    private Clube clube;




}
