package com.betha.projeto.projeto.enterprise;

import com.betha.projeto.projeto.model.Sexo;

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
    @Column(name = "SEXO")
    private Sexo sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
