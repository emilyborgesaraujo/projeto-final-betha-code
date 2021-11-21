package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long>, QuerydslPredicateExecutor<Artigo> {

    List<Artigo> findByDescricao(String descricao);

    List<Artigo> findByDataPublicacao(LocalDate dataPublicacao);

    List<Artigo> findByUsuarioResponsavelPubli(Usuario usuarioResponsavelPubli);

    List<Artigo> findByArquivo(String arquivo);

    List<Artigo> findByStatusArtigo(StatusArtigo statusArtigo);
}
