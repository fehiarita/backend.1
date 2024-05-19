package com.postgresql.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Clube")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_clube;

    @Column(nullable = false)
    private String nome_clube;

    @Column(nullable = false)
    private String endereco_clube;

    @Column(nullable = false)
    private String telefone_clube;

}
