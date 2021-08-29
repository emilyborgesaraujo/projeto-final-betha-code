package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractPessoaFisica;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario extends AbstractPessoaFisica {

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @Transient
    private List<Curso> meusCursos;
    @Transient
    private List<Artigo> meusArtigos;
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

    public List<Curso> getMeusCursos() {
        return meusCursos;
    }

    public void setMeusCursos(List<Curso> meusCursos) {
        this.meusCursos = meusCursos;
    }

    public List<Artigo> getMeusArtigos() {
        return meusArtigos;
    }

    public void setMeusArtigos(List<Artigo> meusArtigos) {
        this.meusArtigos = meusArtigos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
