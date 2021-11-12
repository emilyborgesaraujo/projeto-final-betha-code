package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Categoria;
import com.betha.projeto.projeto.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByDescricao(String descricao);

    List<Categoria> findByInstituicao(Instituicao instituicao);
}
