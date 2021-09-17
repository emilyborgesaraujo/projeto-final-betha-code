package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.AbstractPessoaJuridica;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Instituicao extends AbstractPessoaJuridica {

    @Transient
    private List<UsuarioEmpresa> usuarios;
    @Transient
    private List<Setor> setores;

    public List<UsuarioEmpresa> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEmpresa> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}
