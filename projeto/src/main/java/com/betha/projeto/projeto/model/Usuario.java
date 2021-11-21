package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractPessoaFisica;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(schema = "projeto",name = "USUARIO")
@Entity
public class Usuario extends AbstractPessoaFisica {

    @NotNull
    @Column(name = "LOGIN")
    private String login;
    @NotNull
    @Column(name = "SENHA")
    private String senha;
    @NotNull
    @Column(name = "NIVEL_USUARIO")
    private NivelUsuario nivelUsuario;
    @ManyToOne
    @JoinColumn(name = "I_CARGO", referencedColumnName = "ID")
    private Cargo cargo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
