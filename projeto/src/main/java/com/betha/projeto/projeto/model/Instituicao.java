package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.AbstractPessoaJuridica;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Instituicao extends AbstractPessoaJuridica {

    @Transient
    private List<Usuario> usuarios;
    @Transient
    private List<Setor> setores;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}
