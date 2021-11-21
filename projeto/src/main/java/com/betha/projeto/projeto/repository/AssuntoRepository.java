package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AssuntoRepository extends JpaRepository<Assunto, Long>, QuerydslPredicateExecutor<Assunto> {

    List<Categoria> findByDescricao(String descricao);
}
