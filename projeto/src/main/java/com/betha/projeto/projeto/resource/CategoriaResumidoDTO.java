package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Categoria;

public class CategoriaResumidoDTO {

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

    public static CategoriaResumidoDTO toDTO(Categoria categoria) {
        CategoriaResumidoDTO dto = new CategoriaResumidoDTO();
        dto.setId(categoria.getId());
        dto.setDescricao(categoria.getDescricao());
        return dto;
    }

    public static Categoria fromDTO(CargoResumidoDTO dto) {
        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
