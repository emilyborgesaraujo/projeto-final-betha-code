package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoRepository repository;

    @GetMapping
    public List<CargoDTO> getCargos() {
        return repository.findAll().stream().map(p -> CargoDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CargoDTO getCargosId(@PathVariable(value = "id") Long cargoId) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID : " + cargoId));

        return CargoDTO.toDTO(cargoFind);
    }

    @PostMapping
    public CargoDTO create(@RequestBody Cargo cargo) {
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
