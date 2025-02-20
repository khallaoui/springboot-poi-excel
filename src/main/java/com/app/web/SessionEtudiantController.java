package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.SessionEtudiant;
import com.app.service.ISessionEtudiantService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sessionEtudiants")
@RequiredArgsConstructor
public class SessionEtudiantController {

    private final ISessionEtudiantService sessionEtudiantService;

    @PostMapping("/create")
    public ResponseEntity<SessionEtudiant> addSessionEtudiant(@Valid @RequestBody SessionEtudiant sessionEtudiant) {
        SessionEtudiant savedSessionEtudiant = sessionEtudiantService.addSessionEtudiant(sessionEtudiant);
        return new ResponseEntity<>(savedSessionEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<SessionEtudiant> getAllSessionEtudiants() {
        return sessionEtudiantService.getAllSessionEtudiants();
    }

    @GetMapping("/get/{id}")
    public SessionEtudiant getSessionEtudiantById(@PathVariable("id") Integer id) {
        return sessionEtudiantService.getSessionEtudiantById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SessionEtudiant> updateSessionEtudiant(@Valid @RequestBody SessionEtudiant sessionEtudiant) {
        SessionEtudiant updatedSessionEtudiant = sessionEtudiantService.updateSessionEtudiant(sessionEtudiant);
        return new ResponseEntity<>(updatedSessionEtudiant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSessionEtudiant(@PathVariable("id") Integer id) {
        sessionEtudiantService.deleteSessionEtudiant(id);
        return new ResponseEntity<>("SessionEtudiant deleted successfully", HttpStatus.OK);
    }
}
