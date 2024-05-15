package com.postgresql.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.postgresql.api.Model.Usuario;

// recurso RESTful:pedaço de dados ou funcionalidade que pode ser acessado e manipulado através de requisições HTTP.
// indica que essa interface deve ser exposta como um recurso REST
@RepositoryRestResource
@Repository
// a parte de "extends" fornece métodos prontos para realizar operações CRUD em objetos Usuario armazenados em um banco de dados.
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
