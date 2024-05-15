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
@Table(name = "usuario")
public class Usuario {
    @Id
    // indica que o banco de dados irá gerar automaticamente os valores para o campo id conforme os registros são inseridos na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // mapea um campo da entidade para uma coluna na tabela 
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true,length = 50)
    private String username;

    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Column(nullable = false)
    private String senha;
}
