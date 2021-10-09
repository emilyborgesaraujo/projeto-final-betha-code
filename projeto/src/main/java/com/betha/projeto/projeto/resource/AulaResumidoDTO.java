package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;

public class AulaResumidoDTO {

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

    public static AulaResumidoDTO toDTO(Aula aula) {
        AulaResumidoDTO dto = new AulaResumidoDTO();
        dto.setId(aula.getId());
        dto.setDescricao(aula.getDescricao());
        return dto;
    }

    public static Aula fromDTO(AulaResumidoDTO dto) {
        Aula entity = new Aula();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
