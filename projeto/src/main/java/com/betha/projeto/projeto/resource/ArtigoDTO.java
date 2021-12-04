package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.model.Categoria;
import com.betha.projeto.projeto.model.StatusArtigo;

import java.time.LocalDate;
import java.util.List;

public class ArtigoDTO {

    private String id;
    private String descricao;
    private LocalDate dataPublicacao;
    private UsuarioResumidoDTO usuarioResponsavelPubli;
    private String arquivo;
    private List<Categoria> categoria;
    private AssuntoResumidoDTO assunto;
    private StatusArtigo statusArtigo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusArtigo getStatusArtigo() {
        return statusArtigo;
    }

    public void setStatusArtigo(StatusArtigo statusArtigo) {
        this.statusArtigo = statusArtigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public UsuarioResumidoDTO getUsuarioResponsavelPubli() {
        return usuarioResponsavelPubli;
    }

    public void setUsuarioResponsavelPubli(UsuarioResumidoDTO usuarioResponsavelPubli) {
        this.usuarioResponsavelPubli = usuarioResponsavelPubli;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public AssuntoResumidoDTO getAssunto() {
        return assunto;
    }

    public void setAssunto(AssuntoResumidoDTO assunto) {
        this.assunto = assunto;
    }

    public static ArtigoDTO toDTO(Artigo artigo) {
        ArtigoDTO dto = new ArtigoDTO();
        dto.setId(artigo.getId().toString());
        dto.setDescricao(artigo.getDescricao());
        dto.setDataPublicacao(artigo.getDataPublicacao());
        dto.setUsuarioResponsavelPubli(UsuarioResumidoDTO.toDTO(artigo.getUsuarioResponsavelPubli()));
        dto.setArquivo(artigo.getArquivo());
        dto.setCategoria(artigo.getCategoria());
        dto.setAssunto(AssuntoResumidoDTO.toDTO(artigo.getAssunto()));
        dto.setStatusArtigo(artigo.getStatusArtigo());
        return dto;
    }

    public static Artigo fromDTO(ArtigoDTO dto) {
        Artigo entity = new Artigo();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setArquivo(dto.getArquivo());
        entity.setCategoria(dto.getCategoria());
        entity.setStatusArtigo(dto.getStatusArtigo());
        return entity;
    }
}
