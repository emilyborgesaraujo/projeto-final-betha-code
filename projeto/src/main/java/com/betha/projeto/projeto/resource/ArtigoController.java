package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoRepository repository;

    @GetMapping
    public List<Artigo> getArtigos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Artigo getArtigoId(@PathVariable(value = "id") Long artigoId) throws EntityNotFoundException {
        Artigo artigoFind = repository.findById(artigoId).orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID : " + artigoId));

        return artigoFind;
    }

    @PostMapping
    public Artigo create(@RequestBody Artigo artigo) {
        return repository.save(artigo);
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

        return repository.save(artigoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long artigoId) throws EntityNotFoundException {
        Artigo artigoFind = repository.findById(artigoId).orElseThrow(() -> new EntityNotFoundException("Artigo não encontrado com ID: " + artigoId));

        repository.delete(artigoFind);

        return ResponseEntity.noContent().build();
    }
}
