package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Categoria;
import com.betha.projeto.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<CategoriaDTO> getCategorias() {
        return repository.findAll().stream().map(p -> CategoriaDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoriaDTO getCategoriaId(@PathVariable(value = "id") Long categoriaId) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID : " + categoriaId));

        return CategoriaDTO.toDTO(categoriaFind);
    }

    @PostMapping
    public CategoriaDTO create(@RequestBody Categoria categoria) {
        return CategoriaDTO.toDTO(repository.save(categoria));
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable(value = "id") Long categoriaId, @RequestBody Categoria categoria) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + categoriaId));

        categoriaFind.setId(categoria.getId());
        categoriaFind.setDescricao(categoria.getDescricao());
        categoriaFind.setInstituicao(categoria.getInstituicao());

        return repository.save(categoriaFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long categoriaId) throws EntityNotFoundException {
        Categoria categoriaFind = repository.findById(categoriaId).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + categoriaId));

        repository.delete(categoriaFind);

        return ResponseEntity.noContent().build();
    }
}
