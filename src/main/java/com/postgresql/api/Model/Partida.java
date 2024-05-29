package com.postgresql.api.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "id_jogador1",nullable = false)
    private Usuario id_jogador1;

    @ManyToOne
    @JoinColumn(name = "id_jogador2", nullable = false)
    private Usuario id_jogador2;

    @ManyToOne
    @JoinColumn(name = "id_ganhador", nullable = true)
    private Usuario id_ganhador;

    @Column(nullable = true)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "clube_id")
    private Clube clube;




}
