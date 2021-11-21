package com.betha.projeto.projeto.enterprise;

import com.betha.projeto.projeto.model.Usuario;
import com.betha.projeto.projeto.model.UsuarioEmpresa;

import java.time.LocalDate;

public interface IPublicavel {

    public String getDescricao();

    public LocalDate getDataPublicacao();

    public Usuario getUsuarioResponsavelPubli();
}
