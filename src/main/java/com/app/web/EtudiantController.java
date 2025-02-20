package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Etudiant;
import com.app.service.IEtudiantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final IEtudiantService etudiantService;

    @PostMapping("/create")
    public ResponseEntity<Etudiant> addEtudiant(@Valid @RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(savedEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/get/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateEtudiant(@Valid @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable("id") Integer id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>("Etudiant deleted successfully", HttpStatus.OK);
    }
}
