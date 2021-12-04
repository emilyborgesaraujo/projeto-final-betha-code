package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.NivelUsuario;
import com.betha.projeto.projeto.model.Sexo;
import com.betha.projeto.projeto.model.Usuario;

import java.time.LocalDate;

public class UsuarioDTO {

    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String login;
    private String senha;
    private NivelUsuario nivelUsuario;
    private CargoResumidoDTO cargo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public CargoResumidoDTO getCargo() {
        return cargo;
    }

    public void setCargo(CargoResumidoDTO cargo) {
        this.cargo = cargo;
    }

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId().toString());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setCpf(usuario.getCpf());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setSexo(usuario.getSexo());
        dto.setLogin(usuario.getLogin());
        dto.setSenha(usuario.getSenha());
        dto.setNivelUsuario(usuario.getNivelUsuario());
        dto.setCargo(CargoResumidoDTO.toDTO(usuario.getCargo()));
        return dto;
    }

    public static Usuario fromDTO(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(Long.getLong(dto.getId()));
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setCpf(dto.getCpf());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setSexo(dto.getSexo());
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity.setNivelUsuario(dto.getNivelUsuario());
        return entity;
    }
}
