package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.model.Categoria;

public class AssuntoDTO {

    private String id;
    private String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static AssuntoDTO toDTO(Assunto assunto) {
        AssuntoDTO dto = new AssuntoDTO();
        dto.setId(assunto.getId().toString());
        dto.setDescricao(assunto.getDescricao());
        return dto;
    }

    public static Assunto fromDTO(AssuntoDTO dto) {
        Assunto entity = new Assunto();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
