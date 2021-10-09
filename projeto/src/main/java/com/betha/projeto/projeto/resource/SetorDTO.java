package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Setor;

public class SetorDTO {

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

    public static SetorDTO toDTO(Setor setor) {
        SetorDTO dto = new SetorDTO();
        dto.setId(setor.getId());
        dto.setDescricao(setor.getDescricao());
        dto.setInstituicao(InstituicaoResumidoDTO.toDTO(setor.getInstituicao()));
        return dto;
    }

    public static Setor fromDTO(SetorDTO dto) {
        Setor entity = new Setor();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        return entity;
    }
}