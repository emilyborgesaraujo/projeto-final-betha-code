package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>, QuerydslPredicateExecutor<Aula> {

    List<Aula> findByDescricao(String descricao);

    List<Aula> findByResumo(String resumo);

    List<Aula> findByDuracao(String duracao);

    List<Aula> findByVideo(String video);

    List<Aula> findByCurso(Curso curso);

}
