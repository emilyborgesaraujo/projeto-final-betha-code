package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.repository.AssuntoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/assuntos")
public class AssuntoController extends AbstractResource {

    @Autowired
    private AssuntoRepository repository;

    @GetMapping
    public List<AssuntoDTO> getAssuntos(@QuerydslPredicate(root = Assunto.class) Predicate predicate) {
        List<AssuntoDTO> result = new ArrayList<>();
        Iterable<Assunto> all = repository.findAll(predicate);
        all.forEach(f -> result.add(AssuntoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public AssuntoDTO getAssuntoId(@PathVariable(value = "id") Long assuntoId) throws EntityNotFoundException {
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontrado com ID : " + assuntoId));

        return AssuntoDTO.toDTO(assuntoFind);
    }

    @PostMapping
    public AssuntoDTO create(@Valid @RequestBody Assunto assunto) {
        return AssuntoDTO.toDTO(repository.save(assunto));
    }

    @PutMapping("/{id}")
    public Assunto update(@PathVariable(value = "id") Long assuntoId, @RequestBody Assunto assunto) throws EntityNotFoundException {
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontrado com ID: " + assuntoId));

        assuntoFind.setId(assunto.getId());
        assuntoFind.setDescricao(assunto.getDescricao());

        return repository.save(assuntoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long assuntoId) throws EntityNotFoundException {
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontrado com ID: " + assuntoId));

        repository.delete(assuntoFind);

        return ResponseEntity.noContent().build();
    }
}
