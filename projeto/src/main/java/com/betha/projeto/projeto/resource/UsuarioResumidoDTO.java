package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Usuario;
import com.betha.projeto.projeto.model.UsuarioEmpresa;

public class UsuarioResumidoDTO {

    private Long id;
    private String nome;
    private String login;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static UsuarioResumidoDTO toDTO(Usuario usuario) {
        UsuarioResumidoDTO dto = new UsuarioResumidoDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setLogin(usuario.getLogin());
        return dto;
    }

    public static Usuario fromDTO(UsuarioResumidoDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setLogin(dto.getLogin());
        return entity;
    }
}
