package com.betha.projeto.projeto.enterprise;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractPessoaJuridica extends AbstractPessoa{

    @NotNull
    @Size(max = 18, min = 14)
    @Column(name = "CNPJ")
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
