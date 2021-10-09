package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.UsuarioEmpresa;

import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return entity;
    }
}
