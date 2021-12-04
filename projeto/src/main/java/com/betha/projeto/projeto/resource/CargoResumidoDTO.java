package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;

public class CargoResumidoDTO {

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

    public static CargoResumidoDTO toDTO(Cargo cargo) {
        CargoResumidoDTO dto = new CargoResumidoDTO();
        dto.setId(cargo.getId().toString());
        dto.setDescricao(cargo.getDescricao());
        return dto;
    }

    public static Cargo fromDTO(CargoResumidoDTO dto) {
        Cargo entity = new Cargo();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
