package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.model.Categoria;

public class AssuntoResumidoDTO {

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

    public static AssuntoResumidoDTO toDTO(Assunto assunto) {
        AssuntoResumidoDTO dto = new AssuntoResumidoDTO();
        dto.setId(assunto.getId().toString());
        dto.setDescricao(assunto.getDescricao());
        return dto;
    }

    public static Assunto fromDTO(AssuntoResumidoDTO dto) {
        Assunto entity = new Assunto();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
