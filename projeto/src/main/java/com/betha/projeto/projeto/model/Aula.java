package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(schema = "projeto",name = "AULA")
@Entity
public class Aula extends AbstractEntity {

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "RESUMO")
    private String resumo;
    @NotNull
    @Column(name = "DURACAO")
    private String duracao;
    @NotNull
    @Column(name = "LINK_VIDEO")
    private String video;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "I_CURSO", referencedColumnName = "ID")
    private Curso curso;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
