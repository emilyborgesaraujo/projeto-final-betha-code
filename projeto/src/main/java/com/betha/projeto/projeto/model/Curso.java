package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private Usuario instrutor;
    @Transient
    private List<Aula> aulas;

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
    public Usuario getUsuarioResponsavelPubli() {
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

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
}
