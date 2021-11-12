package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByDescricao(String descricao);

    List<Curso> findByObjetivo(String objetivo);

    List<Curso> findByDuracaoTotal(String duracaoTotal);

    List<Curso> findByDataPublicacao(LocalDate dataPublicacao);

    List<Curso> findByCategoria(Categoria categoria);

    List<Curso> findByInstrutor(UsuarioEmpresa instrutor);

    List<Curso> findByInstituicao(Instituicao instituicao);

    List<Curso> findByStatusCurso(StatusCurso statusCurso);
}
