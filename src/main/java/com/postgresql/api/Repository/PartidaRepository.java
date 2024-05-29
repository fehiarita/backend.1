package com.postgresql.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.postgresql.api.Model.Partida;

@RepositoryRestResource
@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

}
