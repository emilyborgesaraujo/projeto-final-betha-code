package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Table(schema = "projeto",name = "ARTIGO")
@Entity
public class Artigo extends AbstractEntity implements IPublicavel {

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotNull
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "I_USUARIO_PUBLICOU", referencedColumnName = "ID")
    private Usuario usuarioResponsavelPubli;
    @NotNull
    @Column(name = "LINK_ARQUIVO")
    private String arquivo;
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "artigo_categorias",
            joinColumns = {@JoinColumn(name = "artigo_id")},
            inverseJoinColumns = {@JoinColumn(name = "categoria_id")}
    )
    private List<Categoria> categoria;
    @ManyToOne
    @JoinColumn(name = "I_ASSUNTO", referencedColumnName = "ID")
    private Assunto assunto;
    @NotNull
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
    public Usuario getUsuarioResponsavelPubli() {
        return usuarioResponsavelPubli;
    }

    public void setUsuarioResponsavelPubli(Usuario usuarioResponsavelPubli) {
        this.usuarioResponsavelPubli = usuarioResponsavelPubli;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
}
