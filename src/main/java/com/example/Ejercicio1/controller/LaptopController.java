package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.entities.Laptop;
import com.example.Ejercicio1.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository repositoriocomputer;
    private final Logger log = (Logger) LoggerFactory.getLogger(LaptopController.class);
    ;

    public LaptopController(LaptopRepository repositoriocomputer) {
        this.repositoriocomputer = repositoriocomputer;
    }

    @Value("${app.message}")
    String message;

    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        System.out.println(message);
        return repositoriocomputer.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> lapOpt = repositoriocomputer.findById(id);

        // Opción 1
        if (lapOpt.isPresent())
            return ResponseEntity.ok(lapOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        if (laptop.getId() != null) {
            log.warn("trying to create a laptop with id ");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = repositoriocomputer.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Triying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!repositoriocomputer.existsById(laptop.getId())) {
            log.warn("Triying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        Laptop result = repositoriocomputer.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {
        if (!repositoriocomputer.existsById(id)) {
            log.warn("Triying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        repositoriocomputer.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Deleting all laptops");
        repositoriocomputer.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
