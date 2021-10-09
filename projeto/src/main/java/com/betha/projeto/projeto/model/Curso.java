package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Table(schema = "projeto",name = "CURSO")
@Entity
public class Curso extends AbstractEntity implements IPublicavel {

    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "OBJETIVO")
    private String objetivo;
    @Column(name = "DURACAO_TOTAL")
    private String duracaoTotal;
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate dataPublicacao;
    @ManyToOne
    @JoinColumn(name = "I_CATEGORIA", referencedColumnName = "ID")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "I_INSTRUTOR", referencedColumnName = "ID")
    private UsuarioEmpresa instrutor;
    @OneToMany(cascade = ALL, mappedBy = "curso")
    private Set<Aula> aulas;
    @ManyToOne
    @JoinColumn(name = "I_INSTITUICAO", referencedColumnName = "ID")
    private Instituicao instituicao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(String duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public UsuarioEmpresa getUsuarioResponsavelPubli() {
        return instrutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UsuarioEmpresa getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(UsuarioEmpresa instrutor) {
        this.instrutor = instrutor;
    }

    public Set<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Set<Aula> aulas) {
        this.aulas = aulas;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
