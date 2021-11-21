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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
