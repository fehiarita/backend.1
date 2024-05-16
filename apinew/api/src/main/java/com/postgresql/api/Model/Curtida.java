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
@Table(name = "curtida")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurtida;

    @OneToOne
    @Column(nullable = false, length = 50)
    private Usuario usuario;   

    @Column
    private LocalDate dataHora;

}
