package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.ArtigoRepository;
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
@RequestMapping("/api/artigos")
public class ArtigoController extends AbstractResource {

    @Autowired
    private ArtigoRepository repository;

    @GetMapping
    public List<ArtigoDTO> getArtigos(@QuerydslPredicate(root = Artigo.class)Predicate predicate) {
        List<ArtigoDTO> result = new ArrayList<>();
        Iterable<Artigo> all = repository.findAll(predicate);
        all.forEach(f -> result.add(ArtigoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public ArtigoDTO getArtigoId(@PathVariable(value = "id") Long artigoId) throws EntityNotFoundException {
        Artigo artigoFind = repository.findById(artigoId).orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID : " + artigoId));

        return ArtigoDTO.toDTO(artigoFind);
    }

    @PostMapping
    public ArtigoDTO create(@Valid @RequestBody Artigo artigo) {
        return ArtigoDTO.toDTO(repository.save(artigo));
    }

    @PutMapping("/{id}")
    public Artigo update(@PathVariable(value = "id") Long artigoId, @RequestBody Artigo artigo) throws EntityNotFoundException {
        Artigo artigoFind = repository.findById(artigoId).orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + artigoId));

        artigoFind.setId(artigo.getId());
        artigoFind.setDescricao(artigo.getDescricao());
        artigoFind.setDataPublicacao(artigo.getDataPublicacao());
        artigoFind.setUsuarioResponsavelPubli(artigo.getUsuarioResponsavelPubli());
        artigoFind.setArquivo(artigo.getArquivo());
        artigoFind.setCategoria(artigo.getCategoria());
        artigoFind.setAssunto(artigo.getAssunto());
        artigoFind.setStatusArtigo(artigo.getStatusArtigo());

        return repository.save(artigoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long artigoId) throws EntityNotFoundException {
        Artigo artigoFind = repository.findById(artigoId).orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + artigoId));

        repository.delete(artigoFind);

        return ResponseEntity.noContent().build();
    }
}
