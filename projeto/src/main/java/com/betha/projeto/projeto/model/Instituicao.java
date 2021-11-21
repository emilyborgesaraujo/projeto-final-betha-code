package com.betha.projeto.projeto.model;

import com.betha.projeto.projeto.enterprise.AbstractEntity;
import com.betha.projeto.projeto.enterprise.AbstractPessoaJuridica;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Table(schema = "projeto",name = "INSTITUICAO")
@Entity
public class Instituicao extends AbstractPessoaJuridica {

}
