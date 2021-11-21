package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Categoria;
import com.betha.projeto.projeto.repository.CategoriaRepository;
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
@RequestMapping("/api/categorias")
public class CategoriaController extends AbstractResource{

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<CategoriaDTO> getCategorias(@QuerydslPredicate(root = Categoria.class) Predicate predicate) {
        List<CategoriaDTO> result = new ArrayList<>();
        Iterable<Categoria> all = repository.findAll(predicate);
        all.forEach(f -> result.add(CategoriaDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public CategoriaDTO getCategoriaId(@PathVariable(value = "id") Long categoriaId) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID : " + categoriaId));

        return CategoriaDTO.toDTO(categoriaFind);
    }

    @PostMapping
    public CategoriaDTO create(@Valid @RequestBody Categoria categoria) {
        return CategoriaDTO.toDTO(repository.save(categoria));
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable(value = "id") Long categoriaId, @RequestBody Categoria categoria) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + categoriaId));

        categoriaFind.setId(categoria.getId());
        categoriaFind.setDescricao(categoria.getDescricao());

        return repository.save(categoriaFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long categoriaId) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + categoriaId));

        repository.delete(categoriaFind);

        return ResponseEntity.noContent().build();
    }
}
