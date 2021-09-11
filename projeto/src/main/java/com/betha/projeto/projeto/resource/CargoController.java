package com.betha.projeto.projeto.resource;

import com.betha.projeto.projeto.model.Cargo;
import com.betha.projeto.projeto.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoRepository repository;

    @GetMapping
    public List<Cargo> getCargos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cargo getCargosId(@PathVariable(value = "id") Long cargoId) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID : " + cargoId));

        return cargoFind;
    }

    @PostMapping
    public Cargo create(@RequestBody Cargo cargo) {
        return repository.save(cargo);
    }

    @PutMapping("/{id}")
    public Cargo update(@PathVariable(value = "id") Long cargoId, @RequestBody Cargo cargo) throws EntityNotFoundException {
        Cargo cargoFind = repository.findById(cargoId).orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com ID: " + cargoId));

        cargoFind.setId(cargo.getId());
        cargoFind.setDescricao(cargo.getDescricao());

        return repository.save(cargoFind);
    }
}