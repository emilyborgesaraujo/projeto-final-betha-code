package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Categoria;
import com.betha.projeto.projeto.model.Curso;
import com.betha.projeto.projeto.model.StatusCurso;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CursoDTO {

    private Long id;
    private String descricao;
    private String objetivo;
    private String duracaoTotal;
    private LocalDate dataPublicacao;
    private List<Categoria> categoria;
    private AssuntoResumidoDTO assunto;
    private UsuarioResumidoDTO instrutor;
    //private Set<AulaResumidoDTO> aulas;
    private StatusCurso statusCurso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusCurso getStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(StatusCurso statusCurso) {
        this.statusCurso = statusCurso;
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

    public UsuarioResumidoDTO getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(UsuarioResumidoDTO instrutor) {
        this.instrutor = instrutor;
    }

//    public Set<AulaResumidoDTO> getAulas() {
//        return aulas;
//    }
//
//    public void setAulas(Set<AulaResumidoDTO> aulas) {
//        this.aulas = aulas;
//    }

    public static CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setDescricao(curso.getDescricao());
        dto.setObjetivo(curso.getObjetivo());
        dto.setDuracaoTotal(curso.getDuracaoTotal());
        dto.setDataPublicacao(curso.getDataPublicacao());
        dto.setCategoria(curso.getCategoria());
        dto.setAssunto(AssuntoResumidoDTO.toDTO(curso.getAssunto()));
        dto.setInstrutor(UsuarioResumidoDTO.toDTO(curso.getInstrutor()));
        //dto.setAulas(curso.getAulas() == null? null :curso.getAulas().stream().map(AulaResumidoDTO::toDTO).collect(Collectors.toSet()));
        dto.setStatusCurso(curso.getStatusCurso());
        return dto;
    }

    public static Curso fromDTO(CursoDTO dto) {
        Curso entity = new Curso();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setObjetivo(dto.getObjetivo());
        entity.setDuracaoTotal(dto.getDuracaoTotal());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setStatusCurso(dto.getStatusCurso());
        //entity.setAulas(dto.getAulas().stream().map(AulaResumidoDTO::fromDTO).collect(Collectors.toSet()));
        return entity;
    }
}
