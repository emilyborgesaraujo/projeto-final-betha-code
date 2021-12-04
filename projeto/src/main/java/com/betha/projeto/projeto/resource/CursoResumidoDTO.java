package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Curso;

public class CursoResumidoDTO {

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

    public static CursoResumidoDTO toDTO(Curso curso) {
        CursoResumidoDTO dto = new CursoResumidoDTO();
        dto.setId(curso.getId().toString());
        dto.setDescricao(curso.getDescricao());
        return dto;
    }

    public static Curso fromDTO(CursoResumidoDTO dto) {
        Curso entity = new Curso();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
