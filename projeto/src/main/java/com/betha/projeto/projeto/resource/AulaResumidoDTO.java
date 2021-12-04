package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;

public class AulaResumidoDTO {

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

    public static AulaResumidoDTO toDTO(Aula aula) {
        AulaResumidoDTO dto = new AulaResumidoDTO();
        dto.setId(aula.getId().toString());
        dto.setDescricao(aula.getDescricao());
        return dto;
    }

    public static Aula fromDTO(AulaResumidoDTO dto) {
        Aula entity = new Aula();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
