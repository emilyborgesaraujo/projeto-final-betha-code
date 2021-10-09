package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Instituicao;

public class InstituicaoResumidoDTO {

    private Long id;
    private String nome;

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

    public static InstituicaoResumidoDTO toDTO(Instituicao instituicao) {
        InstituicaoResumidoDTO dto = new InstituicaoResumidoDTO();
        dto.setId(instituicao.getId());
        dto.setNome(instituicao.getNome());
        return dto;
    }

    public static Instituicao fromDTO(InstituicaoResumidoDTO dto) {
        Instituicao entity = new Instituicao();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}
