package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.enterprise.ValidationException;
import com.betha.projeto.projeto.model.QUsuario;
import com.betha.projeto.projeto.model.QUsuarioEmpresa;
import com.betha.projeto.projeto.model.Usuario;
import com.betha.projeto.projeto.model.UsuarioEmpresa;
import com.betha.projeto.projeto.repository.UsuarioRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController extends AbstractResource{

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<UsuarioDTO> getUsuarios(@QuerydslPredicate(root = Usuario.class) Predicate predicate) {
        List<UsuarioDTO> result = new ArrayList<>();
        Iterable<Usuario> all = repository.findAll(predicate);
        all.forEach(f -> result.add(UsuarioDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioId(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID : " + usuarioId));

        return UsuarioDTO.toDTO(usuarioFind);
    }

    @PostMapping
    public UsuarioDTO create(@Valid @RequestBody Usuario usuario) throws com.betha.projeto.projeto.enterprise.ValidationException {

        Optional<Usuario> one = repository.findOne(QUsuario.usuario.login.eq(usuario.getLogin()));

        if(one.isPresent()) {
            throw new ValidationException("Já existe um usuário com o mesmo login registrado!");
        }


        return UsuarioDTO.toDTO(repository.save(usuario));
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable(value = "id") Long usuarioId, @RequestBody Usuario usuario) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuarioId));

        usuarioFind.setId(usuario.getId());
        usuarioFind.setNome(usuario.getNome());
        usuarioFind.setEmail(usuario.getEmail());
        usuarioFind.setTelefone(usuario.getTelefone());
        usuarioFind.setCpf(usuario.getCpf());
        usuarioFind.setDataNascimento(usuario.getDataNascimento());
        usuarioFind.setSexo(usuario.getSexo());
        usuarioFind.setLogin(usuario.getLogin());
        usuarioFind.setSenha(usuario.getSenha());
        usuarioFind.setNivelUsuario(usuario.getNivelUsuario());
        usuarioFind.setCargo(usuario.getCargo());

        return repository.save(usuarioFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + usuarioId));

        repository.delete(usuarioFind);

        return ResponseEntity.noContent().build();
    }

}
