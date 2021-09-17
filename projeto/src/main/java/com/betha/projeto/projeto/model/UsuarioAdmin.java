package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractPessoaFisica;
import com.betha.projeto.projeto.enterprise.IUsuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class UsuarioAdmin extends AbstractPessoaFisica implements IUsuario {

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @Transient
    private List<Instituicao> instituicoes;

    @Override
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }
}
