package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Artigo extends AbstractEntity implements IPublicavel {

    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate dataPublicacao;
    @ManyToOne
    @JoinColumn(name = "I_USUARIO_PUBLICOU", referencedColumnName = "ID")
    private UsuarioEmpresa usuarioResponsavelPubli;
    @Column(name = "LINK_ARQUIVO")
    private String arquivo;
    @ManyToOne
    @JoinColumn(name = "I_CATEGORIA", referencedColumnName = "ID")
    private Categoria categoria;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public UsuarioEmpresa getUsuarioResponsavelPubli() {
        return usuarioResponsavelPubli;
    }

    public void setUsuarioResponsavelPubli(UsuarioEmpresa usuarioResponsavelPubli) {
        this.usuarioResponsavelPubli = usuarioResponsavelPubli;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
