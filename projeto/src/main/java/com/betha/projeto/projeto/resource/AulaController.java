package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Assunto;
import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.AulaRepository;
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
@RequestMapping("/api/aulas")
public class AulaController extends AbstractResource{

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public List<AulaDTO> getAulas(@QuerydslPredicate(root = Aula.class) Predicate predicate) {
        List<AulaDTO> result = new ArrayList<>();
        Iterable<Aula> all = repository.findAll(predicate);
        all.forEach(f -> result.add(AulaDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public AulaDTO getAulaId(@PathVariable(value = "id") Long aulaId) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID : " + aulaId));

        return AulaDTO.toDTO(aulaFind);
    }

    @PostMapping
    public AulaDTO create(@Valid @RequestBody Aula aula) {
        return AulaDTO.toDTO(repository.save(aula));
    }

    @PutMapping("/{id}")
    public Aula update(@PathVariable(value = "id") Long aulaId, @RequestBody Aula aula) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID: " + aulaId));

        aulaFind.setId(aula.getId());
        aulaFind.setDescricao(aula.getDescricao());
        aulaFind.setResumo(aula.getResumo());
        aulaFind.setDuracao(aula.getDuracao());
        aulaFind.setVideo(aula.getVideo());
        aulaFind.setCurso(aula.getCurso());

        return repository.save(aulaFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long aulaId) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID: " + aulaId));

        repository.delete(aulaFind);

        return ResponseEntity.noContent().build();
    }
}
