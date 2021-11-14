package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Artigo;
import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.CargoRepository;
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
@RequestMapping("/api/cargos")
public class CargoController extends AbstractResource{

    @Autowired
    private CargoRepository repository;

    @GetMapping
    public List<CargoDTO> getCargos(@QuerydslPredicate(root = Cargo.class) Predicate predicate) {
        List<CargoDTO> result = new ArrayList<>();
        Iterable<Cargo> all = repository.findAll(predicate);
        all.forEach(f -> result.add(CargoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public CargoDTO getCargosId(@PathVariable(value = "id") Long cargoId) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID : " + cargoId));

        return CargoDTO.toDTO(cargoFind);
    }

    @PostMapping
    public CargoDTO create(@Valid @RequestBody Cargo cargo) {
        return CargoDTO.toDTO(repository.save(cargo));
    }

    @PutMapping("/{id}")
    public Cargo update(@PathVariable(value = "id") Long cargoId, @RequestBody Cargo cargo) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID: " + cargoId));

        cargoFind.setId(cargo.getId());
        cargoFind.setDescricao(cargo.getDescricao());
        cargoFind.setInstituicao(cargo.getInstituicao());

        return repository.save(cargoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cargoId) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID: " + cargoId));

        repository.delete(cargoFind);

        return ResponseEntity.noContent().build();
    }
}
