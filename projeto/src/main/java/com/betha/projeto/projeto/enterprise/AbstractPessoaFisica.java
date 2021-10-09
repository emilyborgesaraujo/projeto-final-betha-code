package com.betha.projeto.projeto.enterprise;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractPessoaFisica extends AbstractPessoa{

    @Column(name = "CPF")
    private String cpf;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
