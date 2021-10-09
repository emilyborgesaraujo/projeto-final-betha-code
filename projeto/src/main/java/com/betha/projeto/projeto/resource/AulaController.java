package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Aula;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @GetMapping
    public List<AulaDTO> getAulas() {
        return repository.findAll().stream().map(p -> AulaDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AulaDTO getAulaId(@PathVariable(value = "id") Long aulaId) throws EntityNotFoundException {
        Aula aulaFind = repository.findById(aulaId).orElseThrow(() -> new EntityNotFoundException("Aula não encontrada com ID : " + aulaId));

        return AulaDTO.toDTO(aulaFind);
    }

    @PostMapping
    public AulaDTO create(@RequestBody Aula aula) {
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
}
