package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.UsuarioAdmin;

import java.time.LocalDate;

public class UsuarioAdminDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDate dataNascimento;
    private String login;
    private String senha;

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

    public static UsuarioAdminDTO toDTO(UsuarioAdmin usuarioAdmin) {
        UsuarioAdminDTO dto = new UsuarioAdminDTO();
        dto.setId(usuarioAdmin.getId());
        dto.setNome(usuarioAdmin.getNome());
        dto.setEmail(usuarioAdmin.getEmail());
        dto.setTelefone(usuarioAdmin.getTelefone());
        dto.setCpf(usuarioAdmin.getCpf());
        dto.setDataNascimento(usuarioAdmin.getDataNascimento());
        dto.setLogin(usuarioAdmin.getLogin());
        dto.setSenha(usuarioAdmin.getSenha());
        return dto;
    }

    public static UsuarioAdmin fromDTO(UsuarioAdminDTO dto) {
        UsuarioAdmin entity = new UsuarioAdmin();
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
