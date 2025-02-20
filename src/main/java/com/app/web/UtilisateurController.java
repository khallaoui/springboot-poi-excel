package com.app.web;

import com.app.entities.Utilisateur;
import com.app.service.IUtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final IUtilisateurService utilisateurService;

    @PostMapping("/create")
    public ResponseEntity<Utilisateur> addUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/get/{id}")
    public Utilisateur getUtilisateurById(@PathVariable("id") Integer id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Utilisateur> updateUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUtilisateur(@PathVariable("id") Integer id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>("Utilisateur deleted successfully", HttpStatus.OK);
    }
}
