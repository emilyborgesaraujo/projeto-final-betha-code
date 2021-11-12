package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.enterprise.ValidationException;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.UsuarioEmpresa;
import com.betha.projeto.projeto.repository.UsuarioEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios-empresa")
public class UsuarioEmpresaController extends AbstractResource{

    @Autowired
    private UsuarioEmpresaRepository repository;

    @GetMapping
    public List<UsuarioEmpresaDTO> getUsuariosEmpresa() {
        return repository.findAll().stream().map(p -> UsuarioEmpresaDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsuarioEmpresaDTO getUsuarioEmpresaId(@PathVariable(value = "id") Long usuarioEmpresaId) throws EntityNotFoundException {
        UsuarioEmpresa usuarioEmpresaFind = repository.findById(usuarioEmpresaId).orElseThrow(() -> new EntityNotFoundException("Usuário da empresa não encontrado com ID : " + usuarioEmpresaId));

        return UsuarioEmpresaDTO.toDTO(usuarioEmpresaFind);
    }

    @PostMapping
    public UsuarioEmpresaDTO create(@Valid @RequestBody UsuarioEmpresa usuarioEmpresa) throws com.betha.projeto.projeto.enterprise.ValidationException {

        List<UsuarioEmpresa> byLogin = repository.findByLogin(usuarioEmpresa.getLogin());

        if(!byLogin.isEmpty()) {
            throw new ValidationException("Já existe um usuário com o mesmo login registrado!");
        }


        return UsuarioEmpresaDTO.toDTO(repository.save(usuarioEmpresa));
    }

    @PutMapping("/{id}")
    public UsuarioEmpresa update(@PathVariable(value = "id") Long usuarioEmpresaId, @RequestBody UsuarioEmpresa usuarioEmpresa) throws EntityNotFoundException {
        UsuarioEmpresa usuarioEmpresaFind = repository.findById(usuarioEmpresaId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID: " + usuarioEmpresaId));

        usuarioEmpresaFind.setId(usuarioEmpresa.getId());
        usuarioEmpresaFind.setNome(usuarioEmpresa.getNome());
        usuarioEmpresaFind.setEmail(usuarioEmpresa.getEmail());
        usuarioEmpresaFind.setTelefone(usuarioEmpresa.getTelefone());
        usuarioEmpresaFind.setCpf(usuarioEmpresa.getCpf());
        usuarioEmpresaFind.setDataNascimento(usuarioEmpresa.getDataNascimento());
        usuarioEmpresaFind.setLogin(usuarioEmpresa.getLogin());
        usuarioEmpresaFind.setSenha(usuarioEmpresa.getSenha());
        usuarioEmpresaFind.setCargo(usuarioEmpresa.getCargo());
        usuarioEmpresaFind.setInstituicao(usuarioEmpresa.getInstituicao());
        usuarioEmpresaFind.setSexo(usuarioEmpresa.getSexo());
        usuarioEmpresaFind.setMeusArtigos(usuarioEmpresa.getMeusArtigos());
        usuarioEmpresaFind.setMeusCursos(usuarioEmpresa.getMeusCursos());
        usuarioEmpresaFind.setNivelUsuario(usuarioEmpresa.getNivelUsuario());

        return repository.save(usuarioEmpresaFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioEmpresaId) throws EntityNotFoundException {
        UsuarioEmpresa usuarioEmpresaFind = repository.findById(usuarioEmpresaId).orElseThrow(() -> new EntityNotFoundException("Usuário da empresa não encontrado com ID: " + usuarioEmpresaId));

        repository.delete(usuarioEmpresaFind);

        return ResponseEntity.noContent().build();
    }
}
