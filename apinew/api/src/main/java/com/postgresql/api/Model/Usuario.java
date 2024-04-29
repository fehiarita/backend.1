package com.postgresql.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private long id;
    private String nome;
    private String email;
    private String nivelHabilidade;
}
