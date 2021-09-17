package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractPessoaFisica;
import com.betha.projeto.projeto.enterprise.IUsuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

public class UsuarioEmpresa extends AbstractPessoaFisica implements IUsuario {

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
    @ManyToOne
    @JoinColumn(name = "I_INSTITUICAO", referencedColumnName = "ID")
    private Instituicao instituicao;
    
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

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
