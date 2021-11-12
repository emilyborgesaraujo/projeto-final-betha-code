package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByDescricao(String descricao);

    List<Cargo> findByInstituicao(Instituicao instituicao);
}
