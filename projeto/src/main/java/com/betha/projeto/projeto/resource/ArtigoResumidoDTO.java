package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;

public class ArtigoResumidoDTO {

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

    public static ArtigoResumidoDTO toDTO(Artigo artigo) {
        ArtigoResumidoDTO dto = new ArtigoResumidoDTO();
        dto.setId(artigo.getId().toString());
        dto.setDescricao(artigo.getDescricao());
        return dto;
    }

    public static Artigo fromDTO(ArtigoResumidoDTO dto) {
        Artigo entity = new Artigo();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
