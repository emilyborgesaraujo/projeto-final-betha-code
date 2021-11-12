package com.betha.projeto.projeto.enterprise;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractPessoa extends AbstractEntity {

    @NotNull
    @Size(max = 150, min = 3)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONE")
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
