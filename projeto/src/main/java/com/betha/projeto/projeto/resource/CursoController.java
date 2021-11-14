package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Curso;
import com.betha.projeto.projeto.repository.CursoRepository;
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
@RequestMapping("/api/cursos")
public class CursoController extends AbstractResource {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<CursoDTO> getCursos(@QuerydslPredicate(root = Curso.class) Predicate predicate) {
        List<CursoDTO> result = new ArrayList<>();
        Iterable<Curso> all = repository.findAll(predicate);
        all.forEach(f -> result.add(CursoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public CursoDTO getCursoId(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID : " + cursoId));

        return CursoDTO.toDTO(cursoFind);
    }

    @PostMapping
    public CursoDTO create(@Valid @RequestBody Curso curso) {
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
        cursoFind.setStatusCurso(curso.getStatusCurso());

        return repository.save(cursoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cursoId) throws EntityNotFoundException {
        Curso cursoFind = repository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com ID: " + cursoId));

        repository.delete(cursoFind);

        return ResponseEntity.noContent().build();
    }
}
