package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.UsuarioAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAdminRepository extends JpaRepository<UsuarioAdmin, Long> {

    List<UsuarioAdmin> findByNome(String nome);

    List<UsuarioAdmin> findByCpf(String cpf);

    List<UsuarioAdmin> findByLogin(String Login);
}
