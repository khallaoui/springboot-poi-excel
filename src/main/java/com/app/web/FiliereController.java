package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Filiere;
import com.app.service.IFiliereService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/filieres")
@RequiredArgsConstructor
public class FiliereController {

    private final IFiliereService filiereService;

    @PostMapping("/create")
    public ResponseEntity<Filiere> addFiliere(@Valid @RequestBody Filiere filiere) {
        Filiere savedFiliere = filiereService.addFiliere(filiere);
        return new ResponseEntity<>(savedFiliere, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @GetMapping("/get/{id}")
    public Filiere getFiliereById(@PathVariable("id") Integer id) {
        return filiereService.getFiliereById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Filiere> updateFiliere(@Valid @RequestBody Filiere filiere) {
        Filiere updatedFiliere = filiereService.updateFiliere(filiere);
        return new ResponseEntity<>(updatedFiliere, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFiliere(@PathVariable("id") Integer id) {
        filiereService.deleteFiliere(id);
        return new ResponseEntity<>("Filiere deleted successfully", HttpStatus.OK);
    }
}
