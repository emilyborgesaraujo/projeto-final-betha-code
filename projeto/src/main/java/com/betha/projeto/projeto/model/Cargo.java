package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(schema = "projeto",name = "CARGO")
@Entity
public class Cargo extends AbstractEntity {

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "I_INSTITUICAO", referencedColumnName = "ID")
    private Instituicao instituicao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
