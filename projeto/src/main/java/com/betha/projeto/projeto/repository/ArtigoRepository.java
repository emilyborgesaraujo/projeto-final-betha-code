package com.betha.projeto.projeto.repository;

import com.betha.projeto.projeto.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
