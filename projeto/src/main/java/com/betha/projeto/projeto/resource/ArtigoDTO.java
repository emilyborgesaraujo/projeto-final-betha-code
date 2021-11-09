package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.StatusArtigo;

import java.time.LocalDate;

public class ArtigoDTO {

    private Long id;
    private String descricao;
    private LocalDate dataPublicacao;
    private UsuarioEmpresaResumidoDTO usuarioResponsavelPubli;
    private String arquivo;
    private CategoriaResumidoDTO categoria;
    private InstituicaoResumidoDTO instituicao;
    private StatusArtigo statusArtigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UsuarioEmpresaResumidoDTO getUsuarioResponsavelPubli() {
        return usuarioResponsavelPubli;
    }

    public void setUsuarioResponsavelPubli(UsuarioEmpresaResumidoDTO usuarioResponsavelPubli) {
        this.usuarioResponsavelPubli = usuarioResponsavelPubli;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public CategoriaResumidoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResumidoDTO categoria) {
        this.categoria = categoria;
    }

    public InstituicaoResumidoDTO getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoResumidoDTO instituicao) {
        this.instituicao = instituicao;
    }

    public static ArtigoDTO toDTO(Artigo artigo) {
        ArtigoDTO dto = new ArtigoDTO();
        dto.setId(artigo.getId());
        dto.setDescricao(artigo.getDescricao());
        dto.setDataPublicacao(artigo.getDataPublicacao());
        dto.setUsuarioResponsavelPubli(UsuarioEmpresaResumidoDTO.toDTO(artigo.getUsuarioResponsavelPubli()));
        dto.setArquivo(artigo.getArquivo());
        dto.setCategoria(CategoriaResumidoDTO.toDTO(artigo.getCategoria()));
        dto.setInstituicao(InstituicaoResumidoDTO.toDTO(artigo.getInstituicao()));
        dto.setStatusArtigo(artigo.getStatusArtigo());
        return dto;
    }

    public static Artigo fromDTO(ArtigoDTO dto) {
        Artigo entity = new Artigo();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setArquivo(dto.getArquivo());
        entity.setStatusArtigo(dto.getStatusArtigo());
        return entity;
    }
}
