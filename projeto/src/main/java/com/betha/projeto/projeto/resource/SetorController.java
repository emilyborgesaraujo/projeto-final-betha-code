package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.model.Setor;
import com.betha.projeto.projeto.repository.SetorRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/setores")
public class SetorController extends AbstractResource{

    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<SetorDTO> getSetores(@QuerydslPredicate(root = Setor.class) Predicate predicate) {
        List<SetorDTO> result = new ArrayList<>();
        Iterable<Setor> all = repository.findAll(predicate);
        all.forEach(f -> result.add(SetorDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public SetorDTO getSetoresId(@PathVariable(value = "id") Long setorId) throws EntityNotFoundException {
        Setor setorFind = repository.findById(setorId).orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com ID : " + setorId));

        return SetorDTO.toDTO(setorFind);
    }

    @PostMapping
    public SetorDTO create(@Valid @RequestBody Setor setor) {
        return SetorDTO.toDTO(repository.save(setor));
    }

    @PutMapping("/{id}")
    public Setor update(@PathVariable(value = "id") Long setorId, @RequestBody Setor setor) throws EntityNotFoundException {
        Setor setorFind = repository.findById(setorId).orElseThrow(() -> new EntityNotFoundException("Setor não encontrado com ID: " + setorId));

        setorFind.setId(setor.getId());
        setorFind.setDescricao(setor.getDescricao());
        setorFind.setInstituicao(setor.getInstituicao());
        setorFind.setCargos(setor.getCargos());

        return repository.save(setorFind);
    }
}
