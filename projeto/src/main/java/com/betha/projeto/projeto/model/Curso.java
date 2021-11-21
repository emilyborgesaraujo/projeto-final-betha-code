package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.IPublicavel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Table(schema = "projeto",name = "CURSO")
@Entity
public class Curso extends AbstractEntity implements IPublicavel {

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotNull
    @Column(name = "OBJETIVO")
    private String objetivo;
    @NotNull
    @Column(name = "DURACAO_TOTAL")
    private String duracaoTotal;
    @NotNull
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate dataPublicacao;
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "curso_categorias",
            joinColumns = {@JoinColumn(name = "curso_id")},
            inverseJoinColumns = {@JoinColumn(name = "categoria_id")}
    )
    private List<Categoria> categoria;
    @ManyToOne
    @JoinColumn(name = "I_ASSUNTO", referencedColumnName = "ID")
    private Assunto assunto;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "I_INSTRUTOR", referencedColumnName = "ID")
    private Usuario instrutor;
//    @OneToMany(cascade = ALL, mappedBy = "curso")
//    private Set<Aula> aulas;
    @NotNull
    @Column(name = "STATUS_CURSO")
    private StatusCurso statusCurso;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusCurso getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(StatusCurso statusCurso) {
        this.statusCurso = statusCurso;
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

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

//    public Set<Aula> getAulas() {
//        return aulas;
//    }
//
//    public void setAulas(Set<Aula> aulas) {
//        this.aulas = aulas;
//    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
}
