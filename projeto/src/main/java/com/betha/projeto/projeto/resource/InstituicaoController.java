package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Instituicao;
import com.betha.projeto.projeto.repository.InstituicaoRepository;
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
@RequestMapping("/api/instituicoes")
public class InstituicaoController extends AbstractResource{

    @Autowired
    private InstituicaoRepository repository;

    @GetMapping
    public List<InstituicaoDTO> getInstituicoes(@QuerydslPredicate(root = Instituicao.class) Predicate predicate) {
        List<InstituicaoDTO> result = new ArrayList<>();
        Iterable<Instituicao> all = repository.findAll(predicate);
        all.forEach(f -> result.add(InstituicaoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public InstituicaoDTO getInstituicaoId(@PathVariable(value = "id") Long instituicaoId) throws EntityNotFoundException {
        Instituicao instituicaoFind = repository.findById(instituicaoId).orElseThrow(() -> new EntityNotFoundException("Instituição não encontrada com ID : " + instituicaoId));

        return InstituicaoDTO.toDTO(instituicaoFind);
    }

    @PostMapping
    public InstituicaoDTO create(@Valid @RequestBody Instituicao instituicao) {
        return InstituicaoDTO.toDTO(repository.save(instituicao));
    }

    @PutMapping("/{id}")
    public Instituicao update(@PathVariable(value = "id") Long instituicaoId, @RequestBody Instituicao instituicao) throws EntityNotFoundException {
        Instituicao instituicaoFind = repository.findById(instituicaoId).orElseThrow(() -> new EntityNotFoundException("Instituição não encontrada com ID: " + instituicaoId));

        instituicaoFind.setId(instituicao.getId());
        instituicaoFind.setNome(instituicao.getNome());
        instituicaoFind.setEmail(instituicao.getEmail());
        instituicaoFind.setTelefone(instituicao.getTelefone());
        instituicaoFind.setCnpj(instituicao.getCnpj());

        return repository.save(instituicaoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long instituicaoId) throws EntityNotFoundException {
        Instituicao instituicaoFind = repository.findById(instituicaoId).orElseThrow(() -> new EntityNotFoundException("Instituição não encontrada com ID: " + instituicaoId));

        repository.delete(instituicaoFind);

        return ResponseEntity.noContent().build();
    }
}
