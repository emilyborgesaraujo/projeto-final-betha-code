package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Instituicao;
import com.betha.projeto.projeto.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoController {

    @Autowired
    private InstituicaoRepository repository;

    @GetMapping
    public List<Instituicao> getInstituicoes() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Instituicao getInstituicaoId(@PathVariable(value = "id") Long instituicaoId) throws EntityNotFoundException {
        Instituicao instituicaoFind = repository.findById(instituicaoId).orElseThrow(() -> new EntityNotFoundException("Instituição não encontrada com ID : " + instituicaoId));

        return instituicaoFind;
    }

    @PostMapping
    public Instituicao create(@RequestBody Instituicao instituicao) {
        return repository.save(instituicao);
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
