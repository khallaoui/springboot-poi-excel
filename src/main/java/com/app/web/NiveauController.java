package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Niveau;
import com.app.service.INiveauService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/niveaux")
@RequiredArgsConstructor
public class NiveauController {

    private final INiveauService niveauService;

    @PostMapping("/create")
    public ResponseEntity<Niveau> addNiveau(@Valid @RequestBody Niveau niveau) {
        Niveau savedNiveau = niveauService.addNiveau(niveau);
        return new ResponseEntity<>(savedNiveau, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveaux();
    }

    @GetMapping("/get/{id}")
    public Niveau getNiveauById(@PathVariable("id") Integer id) {
        return niveauService.getNiveauById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Niveau> updateNiveau(@Valid @RequestBody Niveau niveau) {
        Niveau updatedNiveau = niveauService.updateNiveau(niveau);
        return new ResponseEntity<>(updatedNiveau, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNiveau(@PathVariable("id") Integer id) {
        niveauService.deleteNiveau(id);
        return new ResponseEntity<>("Niveau deleted successfully", HttpStatus.OK);
    }
}
