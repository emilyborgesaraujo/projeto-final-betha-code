package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Categoria;

public class CategoriaResumidoDTO {

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

    public static CategoriaResumidoDTO toDTO(Categoria categoria) {
        CategoriaResumidoDTO dto = new CategoriaResumidoDTO();
        dto.setId(categoria.getId().toString());
        dto.setDescricao(categoria.getDescricao());
        return dto;
    }

    public static Categoria fromDTO(CargoResumidoDTO dto) {
        Categoria entity = new Categoria();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
