package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public List<Aula> getAulas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aula getAulaId(@PathVariable(value = "id") Long aulaId) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID : " + aulaId));

        return aulaFind;
    }

    @PostMapping
    public Aula create(@RequestBody Aula aula) {
        return repository.save(aula);
    }

    @PutMapping("/{id}")
    public Aula update(@PathVariable(value = "id") Long aulaId, @RequestBody Aula aula) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID: " + aulaId));

        aulaFind.setId(aula.getId());
        aulaFind.setDescricao(aula.getDescricao());
        aulaFind.setResumo(aula.getResumo());
        aulaFind.setDuracao(aula.getDuracao());
        aulaFind.setVideo(aula.getVideo());

        return repository.save(aulaFind);
    }
}
