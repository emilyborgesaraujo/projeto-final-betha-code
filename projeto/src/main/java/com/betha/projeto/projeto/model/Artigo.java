package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(schema = "projeto",name = "ARTIGO")
@Entity
public class Artigo extends AbstractEntity implements IPublicavel {

    @NotNull
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
    @ManyToOne
    @JoinColumn(name = "I_INSTITUICAO", referencedColumnName = "ID")
    private Instituicao instituicao;
    @Column(name = "STATUS_ARTIGO")
    private StatusArtigo statusArtigo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusArtigo getStatusArtigo() {
        return statusArtigo;
    }

    public void setStatusArtigo(StatusArtigo statusArtigo) {
        this.statusArtigo = statusArtigo;
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

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
