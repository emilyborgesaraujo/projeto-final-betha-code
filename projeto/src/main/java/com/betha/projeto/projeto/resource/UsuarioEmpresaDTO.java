package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.*;

import java.time.LocalDate;
import java.util.List;

public class UsuarioEmpresaDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDate dataNascimento;
    private String login;
    private String senha;
    private CargoResumidoDTO cargo;
    private InstituicaoResumidoDTO instituicao;
    private Sexo sexo;
    private List<Artigo> meusArtigos;
    private List<Curso> meusCursos;
    private NivelUsuario nivelUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CargoResumidoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoResumidoDTO cargo) {
        this.cargo = cargo;
    }

    public InstituicaoResumidoDTO getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoResumidoDTO instituicao) {
        this.instituicao = instituicao;
    }

    public List<Artigo> getMeusArtigos() {
        return meusArtigos;
    }

    public void setMeusArtigos(List<Artigo> meusArtigos) {
        this.meusArtigos = meusArtigos;
    }

    public List<Curso> getMeusCursos() {
        return meusCursos;
    }

    public void setMeusCursos(List<Curso> meusCursos) {
        this.meusCursos = meusCursos;
    }

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public static UsuarioEmpresaDTO toDTO(UsuarioEmpresa usuarioEmpresa) {
        UsuarioEmpresaDTO dto = new UsuarioEmpresaDTO();
        dto.setId(usuarioEmpresa.getId());
        dto.setNome(usuarioEmpresa.getNome());
        dto.setEmail(usuarioEmpresa.getEmail());
        dto.setTelefone(usuarioEmpresa.getTelefone());
        dto.setCpf(usuarioEmpresa.getCpf());
        dto.setDataNascimento(usuarioEmpresa.getDataNascimento());
        dto.setLogin(usuarioEmpresa.getLogin());
        dto.setSenha(usuarioEmpresa.getSenha());
        dto.setCargo(CargoResumidoDTO.toDTO(usuarioEmpresa.getCargo()));
        dto.setInstituicao(InstituicaoResumidoDTO.toDTO(usuarioEmpresa.getInstituicao()));
        dto.setSexo(usuarioEmpresa.getSexo());
        dto.setMeusArtigos(usuarioEmpresa.getMeusArtigos());
        dto.setMeusCursos(usuarioEmpresa.getMeusCursos());
        dto.setNivelUsuario(usuarioEmpresa.getNivelUsuario());
        return dto;
    }

    public static UsuarioEmpresa fromDTO(UsuarioEmpresaDTO dto) {
        UsuarioEmpresa entity = new UsuarioEmpresa();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity.setSexo(dto.getSexo());
        entity.setMeusArtigos(dto.getMeusArtigos());
        entity.setMeusCursos(dto.getMeusCursos());
        entity.setNivelUsuario(dto.getNivelUsuario());
        return entity;
    }
}
