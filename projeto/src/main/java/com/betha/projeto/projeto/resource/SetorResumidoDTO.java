package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Setor;

public class SetorResumidoDTO {

    private Long id;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static SetorResumidoDTO toDTO(Setor setor) {
        SetorResumidoDTO dto = new SetorResumidoDTO();
        dto.setId(setor.getId());
        dto.setDescricao(setor.getDescricao());
        return dto;
    }

    public static Setor fromDTO(SetorResumidoDTO dto) {
        Setor entity = new Setor();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
