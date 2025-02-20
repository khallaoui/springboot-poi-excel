package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Inscription;
import com.app.service.IInscriptionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inscriptions")
@RequiredArgsConstructor
public class InscriptionController {

    private final IInscriptionService inscriptionService;

    @PostMapping("/create")
    public ResponseEntity<Inscription> addInscription(@Valid @RequestBody Inscription inscription) {
        Inscription savedInscription = inscriptionService.addInscription(inscription);
        return new ResponseEntity<>(savedInscription, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @GetMapping("/get/{id}")
    public Inscription getInscriptionById(@PathVariable("id") Integer id) {
        return inscriptionService.getInscriptionById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Inscription> updateInscription(@Valid @RequestBody Inscription inscription) {
        Inscription updatedInscription = inscriptionService.updateInscription(inscription);
        return new ResponseEntity<>(updatedInscription, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInscription(@PathVariable("id") Integer id) {
        inscriptionService.deleteInscription(id);
        return new ResponseEntity<>("Inscription deleted successfully", HttpStatus.OK);
    }
}
