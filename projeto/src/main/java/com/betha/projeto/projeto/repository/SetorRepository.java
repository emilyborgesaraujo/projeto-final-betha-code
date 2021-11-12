package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Instituicao;
import com.betha.projeto.projeto.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

    List<Setor> findByDescricao(String descricao);

    List<Setor> findByInstituicao(Instituicao instituicao);
}
