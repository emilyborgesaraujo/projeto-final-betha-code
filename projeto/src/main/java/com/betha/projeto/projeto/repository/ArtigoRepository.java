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

    List<Artigo> findByUsuarioResponsavelPubli(UsuarioEmpresa usuarioResponsavelPubli);

    List<Artigo> findByArquivo(String arquivo);

    List<Artigo> findByCategoria(Categoria categoria);

    List<Artigo> findByInstituicao(Instituicao instituicao);

    List<Artigo> findByStatusArtigo(StatusArtigo statusArtigo);
}
