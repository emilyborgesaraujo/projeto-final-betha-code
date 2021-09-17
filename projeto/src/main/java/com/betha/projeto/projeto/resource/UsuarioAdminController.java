package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.UsuarioAdmin;
import com.betha.projeto.projeto.repository.UsuarioAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios-admin")
public class UsuarioAdminController {

    @Autowired
    private UsuarioAdminRepository repository;

    @GetMapping
    public List<UsuarioAdmin> getUsuariosAdmin() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioAdmin getUsuarioAdminId(@PathVariable(value = "id") Long usuarioAdminId) throws EntityNotFoundException {
        UsuarioAdmin usuarioAdminFind = repository.findById(usuarioAdminId).orElseThrow(() -> new EntityNotFoundException("Usuário admin não encontrado com ID : " + usuarioAdminId));

        return usuarioAdminFind;
    }

    @PostMapping
    public UsuarioAdmin create(@RequestBody UsuarioAdmin usuarioAdmin) {
        return repository.save(usuarioAdmin);
    }

    @PutMapping("/{id}")
    public UsuarioAdmin update(@PathVariable(value = "id") Long usuarioAdminId, @RequestBody UsuarioAdmin usuarioAdmin) throws EntityNotFoundException {
        UsuarioAdmin usuarioAdminFind = repository.findById(usuarioAdminId).orElseThrow(() -> new EntityNotFoundException("Usuário Admin não encontrado com ID: " + usuarioAdminId));

        usuarioAdminFind.setId(usuarioAdmin.getId());
        usuarioAdminFind.setNome(usuarioAdmin.getNome());
        usuarioAdminFind.setEmail(usuarioAdmin.getEmail());
        usuarioAdminFind.setTelefone(usuarioAdmin.getTelefone());
        usuarioAdminFind.setCpf(usuarioAdmin.getCpf());
        usuarioAdminFind.setDataNascimento(usuarioAdmin.getDataNascimento());
        usuarioAdminFind.setEmail(usuarioAdmin.getEmail());
        usuarioAdminFind.setSenha(usuarioAdminFind.getSenha());

        return repository.save(usuarioAdminFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioAdminId) throws EntityNotFoundException {
        UsuarioAdmin usuarioAdminFind = repository.findById(usuarioAdminId).orElseThrow(() -> new EntityNotFoundException("Usuário Admin não encontrado com ID: " + usuarioAdminId));

        repository.delete(usuarioAdminFind);

        return ResponseEntity.noContent().build();
    }
}