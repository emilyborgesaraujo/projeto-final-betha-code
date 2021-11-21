package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Instituicao;
import com.betha.projeto.projeto.model.UsuarioEmpresa;

import java.util.Set;
import java.util.stream.Collectors;

public class InstituicaoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static InstituicaoDTO toDTO(Instituicao instituicao) {
        InstituicaoDTO dto = new InstituicaoDTO();
        dto.setId(instituicao.getId());
        dto.setNome(instituicao.getNome());
        dto.setEmail(instituicao.getEmail());
        dto.setTelefone(instituicao.getTelefone());
        dto.setCnpj(instituicao.getCnpj());
        return dto;
    }

    public static Instituicao fromDTO(InstituicaoDTO dto) {
        Instituicao entity = new Instituicao();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCnpj(dto.getCnpj());
        return entity;
    }
}
