package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Curso;
import com.betha.projeto.projeto.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<CursoDTO> getCursos() {
        return repository.findAll().stream().map(p -> CursoDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CursoDTO getCursoId(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID : " + cursoId));

        return CursoDTO.toDTO(cursoFind);
    }

    @PostMapping
    public CursoDTO create(@RequestBody Curso curso) {
        return CursoDTO.toDTO(repository.save(curso));
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
        cursoFind.setInstituicao(curso.getInstituicao());

        return repository.save(cursoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + cursoId));

        repository.delete(cursoFind);

        return ResponseEntity.noContent().build();
    }
}
