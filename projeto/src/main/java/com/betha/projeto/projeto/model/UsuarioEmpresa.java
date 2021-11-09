package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractPessoaFisica;
import com.betha.projeto.projeto.enterprise.IUsuario;

import javax.persistence.*;
import java.util.List;

@Table(schema = "projeto",name = "USUARIO_EMPRESA")
@Entity
public class UsuarioEmpresa extends AbstractPessoaFisica implements IUsuario {

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "NIVEL_USUARIO")
    private NivelUsuario nivelUsuario;
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "usuarioEmpresa_cursos",
            joinColumns = {@JoinColumn(name = "usuarioEmpresa_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
    private List<Curso> meusCursos;
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "usuarioEmpresa_artigos",
            joinColumns = {@JoinColumn(name = "usuarioEmpresa_id")},
            inverseJoinColumns = {@JoinColumn(name = "artigo_id")}
    )
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

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
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
