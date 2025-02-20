package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Enseignant;
import com.app.service.IEnseignantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enseignants")
@RequiredArgsConstructor
public class EnseignantController {

    private final IEnseignantService enseignantService;

    @PostMapping("/create")
    public ResponseEntity<Enseignant> addEnseignant(@Valid @RequestBody Enseignant enseignant) {
        Enseignant savedEnseignant = enseignantService.addEnseignant(enseignant);
        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/get/{id}")
    public Enseignant getEnseignantById(@PathVariable("id") Integer id) {
        return enseignantService.getEnseignantById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Enseignant> updateEnseignant(@Valid @RequestBody Enseignant enseignant) {
        Enseignant updatedEnseignant = enseignantService.updateEnseignant(enseignant);
        return new ResponseEntity<>(updatedEnseignant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable("id") Integer id) {
        enseignantService.deleteEnseignant(id);
        return new ResponseEntity<>("Enseignant deleted successfully", HttpStatus.OK);
    }
}
