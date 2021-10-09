package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Curso;

public class CursoResumidoDTO {

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

    public static CursoResumidoDTO toDTO(Curso curso) {
        CursoResumidoDTO dto = new CursoResumidoDTO();
        dto.setId(curso.getId());
        dto.setDescricao(curso.getDescricao());
        return dto;
    }

    public static Curso fromDTO(CursoResumidoDTO dto) {
        Curso entity = new Curso();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
