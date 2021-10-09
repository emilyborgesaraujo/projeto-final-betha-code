package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Curso;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class CursoDTO {

    private Long id;
    private String descricao;
    private String objetivo;
    private String duracaoTotal;
    private LocalDate dataPublicacao;
    private CategoriaResumidoDTO categoria;
    private UsuarioEmpresaResumidoDTO instrutor;
    private InstituicaoResumidoDTO instituicao;
    private Set<AulaResumidoDTO> aulas;

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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(String duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public CategoriaResumidoDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResumidoDTO categoria) {
        this.categoria = categoria;
    }

    public UsuarioEmpresaResumidoDTO getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(UsuarioEmpresaResumidoDTO instrutor) {
        this.instrutor = instrutor;
    }

    public InstituicaoResumidoDTO getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoResumidoDTO instituicao) {
        this.instituicao = instituicao;
    }

    public Set<AulaResumidoDTO> getAulas() {
        return aulas;
    }

    public void setAulas(Set<AulaResumidoDTO> aulas) {
        this.aulas = aulas;
    }

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setDescricao(curso.getDescricao());
        dto.setObjetivo(curso.getObjetivo());
        dto.setDuracaoTotal(curso.getDuracaoTotal());
        dto.setDataPublicacao(curso.getDataPublicacao());
        dto.setCategoria(CategoriaResumidoDTO.toDTO(curso.getCategoria()));
        dto.setInstrutor(UsuarioEmpresaResumidoDTO.toDTO(curso.getInstrutor()));
        dto.setInstituicao(InstituicaoResumidoDTO.toDTO(curso.getInstituicao()));
        dto.setAulas(curso.getAulas() == null? null :curso.getAulas().stream().map(AulaResumidoDTO::toDTO).collect(Collectors.toSet()));
        return dto;
    }

    public static Curso fromDTO(CursoDTO dto) {
        Curso entity = new Curso();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setObjetivo(dto.getObjetivo());
        entity.setDuracaoTotal(dto.getDuracaoTotal());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setAulas(dto.getAulas().stream().map(AulaResumidoDTO::fromDTO).collect(Collectors.toSet()));
        return entity;
    }
}
