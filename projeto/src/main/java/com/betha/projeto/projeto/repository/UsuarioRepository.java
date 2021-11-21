package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.NivelUsuario;
import com.betha.projeto.projeto.model.Usuario;
import com.betha.projeto.projeto.model.UsuarioEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>, QuerydslPredicateExecutor<Usuario> {

    List<UsuarioEmpresa> findByNome(String nome);

    List<UsuarioEmpresa> findByCpf(String cpf);

    List<UsuarioEmpresa> findByLogin(String login);

    List<UsuarioEmpresa> findByNivelUsuario(NivelUsuario nivelUsuario);
}
