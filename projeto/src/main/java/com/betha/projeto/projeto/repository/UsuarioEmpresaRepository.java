package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, Long>, QuerydslPredicateExecutor<UsuarioEmpresa> {

    List<UsuarioEmpresa> findByNome(String nome);

    List<UsuarioEmpresa> findByCpf(String cpf);

    List<UsuarioEmpresa> findByLogin(String login);

    List<UsuarioEmpresa> findByNivelUsuario(NivelUsuario nivelUsuario);

    List<UsuarioEmpresa> findByCargo(Cargo cargo);

    List<UsuarioEmpresa> findByInstituicao(Instituicao instituicao);
}
