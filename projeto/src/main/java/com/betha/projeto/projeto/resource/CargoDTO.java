package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Instituicao;

public class CargoDTO {

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

    public static CargoDTO toDTO(Cargo cargo) {
        CargoDTO dto = new CargoDTO();
        dto.setId(cargo.getId());
        dto.setDescricao(cargo.getDescricao());
        return dto;
    }

    public static Cargo fromDTO(CargoDTO dto) {
        Cargo entity = new Cargo();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
