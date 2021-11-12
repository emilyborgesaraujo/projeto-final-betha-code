package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Table(schema = "projeto",name = "SETOR")
@Entity
public class Setor extends AbstractEntity {

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "I_INSTITUICAO", referencedColumnName = "ID")
    private Instituicao instituicao;
    @NotNull
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "setor_cargos",
            joinColumns = {@JoinColumn(name = "setor_id")},
            inverseJoinColumns = {@JoinColumn(name = "cargos_id")}
    )
    private Set<Cargo> cargos;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
