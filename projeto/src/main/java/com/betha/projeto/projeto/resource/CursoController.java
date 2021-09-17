package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Curso;
import com.betha.projeto.projeto.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> getCursos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso getCursoId(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID : " + cursoId));

        return cursoFind;
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable(value = "id") Long cursoId, @RequestBody Curso curso) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + cursoId));

        cursoFind.setId(cursoFind.getId());
        cursoFind.setDescricao(curso.getDescricao());
        cursoFind.setObjetivo(curso.getObjetivo());
        cursoFind.setDuracaoTotal(curso.getDuracaoTotal());
        cursoFind.setDataPublicacao(curso.getDataPublicacao());
        cursoFind.setCategoria(curso.getCategoria());
        cursoFind.setInstrutor(curso.getInstrutor());

        return repository.save(cursoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + cursoId));

        repository.delete(cursoFind);

        return ResponseEntity.noContent().build();
    }
}
