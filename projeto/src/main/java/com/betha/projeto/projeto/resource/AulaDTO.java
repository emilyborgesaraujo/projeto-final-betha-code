package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;

public class AulaDTO {

    private Long id;
    private String descricao;
    private String resumo;
    private String duracao;
    private String video;
    private CursoResumidoDTO curso;

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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public CursoResumidoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoResumidoDTO curso) {
        this.curso = curso;
    }

    public static AulaDTO toDTO(Aula aula) {
        AulaDTO dto = new AulaDTO();
        dto.setId(aula.getId());
        dto.setDescricao(aula.getDescricao());
        dto.setResumo(aula.getResumo());
        dto.setDuracao(aula.getDuracao());
        dto.setVideo(aula.getVideo());
        dto.setCurso(CursoResumidoDTO.toDTO(aula.getCurso()));
        return dto;
    }

    public static Aula fromDTO(AulaDTO dto) {
        Aula entity = new Aula();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setResumo(dto.getResumo());
        entity.setDuracao(dto.getDuracao());
        entity.setVideo(dto.getVideo());
        return entity;
    }
}
