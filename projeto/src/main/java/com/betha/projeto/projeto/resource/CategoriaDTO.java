package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Categoria;

public class CategoriaDTO {

    private Long id;
    private String descricao;
    private InstituicaoResumidoDTO instituicao;

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

    public InstituicaoResumidoDTO getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoResumidoDTO instituicao) {
        this.instituicao = instituicao;
    }

    public static CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setDescricao(categoria.getDescricao());
        dto.setInstituicao(InstituicaoResumidoDTO.toDTO(categoria.getInstituicao()));
        return dto;
    }

    public static Categoria fromDTO(CategoriaDTO dto) {
        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}
