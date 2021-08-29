package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Aula extends AbstractEntity {

    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "RESUMO")
    private String resumo;
    @Column(name = "DURACAO")
    private String duracao;
    @Column(name = "LINK_VIDEO")
    private String video;

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
}
