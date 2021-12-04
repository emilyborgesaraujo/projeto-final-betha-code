package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Instituicao;

public class InstituicaoResumidoDTO {

    private String id;
    private String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static InstituicaoResumidoDTO toDTO(Instituicao instituicao) {
        InstituicaoResumidoDTO dto = new InstituicaoResumidoDTO();
        dto.setId(instituicao.getId().toString());
        dto.setNome(instituicao.getNome());
        return dto;
    }

    public static Instituicao fromDTO(InstituicaoResumidoDTO dto) {
        Instituicao entity = new Instituicao();
        entity.setId(Long.getLong(dto.getId()));
        entity.setNome(dto.getNome());
        return entity;
    }
}
