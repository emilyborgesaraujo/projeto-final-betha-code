package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.UsuarioEmpresa;

public class UsuarioEmpresaResumidoDTO {

    private Long id;
    private String nome;

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

    public static UsuarioEmpresaResumidoDTO toDTO(UsuarioEmpresa usuarioEmpresa) {
        UsuarioEmpresaResumidoDTO dto = new UsuarioEmpresaResumidoDTO();
        dto.setId(usuarioEmpresa.getId());
        dto.setNome(usuarioEmpresa.getNome());
        return dto;
    }

    public static UsuarioEmpresa fromDTO(UsuarioEmpresaResumidoDTO dto) {
        UsuarioEmpresa entity = new UsuarioEmpresa();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        return entity;
    }
}
