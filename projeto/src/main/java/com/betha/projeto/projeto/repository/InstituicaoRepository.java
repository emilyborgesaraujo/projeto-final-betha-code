package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>, QuerydslPredicateExecutor<Instituicao> {

    List<Instituicao> findByNome(String nome);

    List<Instituicao> findByCnpj(String cnpj);
}
