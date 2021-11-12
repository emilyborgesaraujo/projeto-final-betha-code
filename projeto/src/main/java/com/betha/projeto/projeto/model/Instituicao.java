package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.AbstractPessoaJuridica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Table(schema = "projeto",name = "INSTITUICAO")
@Entity
public class Instituicao extends AbstractPessoaJuridica {

    @NotNull
    @OneToMany(cascade = ALL, mappedBy = "instituicao")
    private Set<UsuarioEmpresa> usuarios;
    @OneToMany(cascade = ALL, mappedBy = "instituicao")
    private Set<Setor> setores;

    public Set<UsuarioEmpresa> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioEmpresa> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Setor> getSetores() {
        return setores;
    }

    public void setSetores(Set<Setor> setores) {
        this.setores = setores;
    }
}
