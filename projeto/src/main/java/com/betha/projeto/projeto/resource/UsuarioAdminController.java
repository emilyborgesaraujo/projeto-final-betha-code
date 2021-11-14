package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.enterprise.ValidationException;
import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.UsuarioAdmin;
import com.betha.projeto.projeto.repository.UsuarioAdminRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios-admin")
public class UsuarioAdminController extends AbstractResource{

    @Autowired
    private UsuarioAdminRepository repository;

    @GetMapping
    public List<UsuarioAdminDTO> getUsuariosAdmin(@QuerydslPredicate(root = UsuarioAdmin.class) Predicate predicate) {
        List<UsuarioAdminDTO> result = new ArrayList<>();
        Iterable<UsuarioAdmin> all = repository.findAll(predicate);
        all.forEach(f -> result.add(UsuarioAdminDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public UsuarioAdminDTO getUsuarioAdminId(@PathVariable(value = "id") Long usuarioAdminId) throws EntityNotFoundException {
        UsuarioAdmin usuarioAdminFind = repository.findById(usuarioAdminId).orElseThrow(() -> new EntityNotFoundException("Usuário admin não encontrado com ID : " + usuarioAdminId));

        return UsuarioAdminDTO.toDTO(usuarioAdminFind);
    }

    @PostMapping
    public UsuarioAdminDTO create(@Valid @RequestBody UsuarioAdmin usuarioAdmin) throws com.betha.projeto.projeto.enterprise.ValidationException {

        List<UsuarioAdmin> byLogin = repository.findByLogin(usuarioAdmin.getLogin());

        if(!byLogin.isEmpty()) {
            throw new ValidationException("Já existe um usuário com o mesmo login registrado!");
        }

        return UsuarioAdminDTO.toDTO(repository.save(usuarioAdmin));
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
        usuarioAdminFind.setSexo(usuarioAdmin.getSexo());

        return repository.save(usuarioAdminFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioAdminId) throws EntityNotFoundException {
        UsuarioAdmin usuarioAdminFind = repository.findById(usuarioAdminId).orElseThrow(() -> new EntityNotFoundException("Usuário Admin não encontrado com ID: " + usuarioAdminId));

        repository.delete(usuarioAdminFind);

        return ResponseEntity.noContent().build();
    }
}
