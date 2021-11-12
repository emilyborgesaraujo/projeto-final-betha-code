package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

    List<Instituicao> findByNome(String nome);

    List<Instituicao> findByCnpj(String cnpj);
}
