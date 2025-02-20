package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Deliberation;
import com.app.service.IDeliberationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/deliberations")
@RequiredArgsConstructor
public class DeliberationController {

    private final IDeliberationService deliberationService;

    @PostMapping("/create")
    public ResponseEntity<Deliberation> addDeliberation(@Valid @RequestBody Deliberation deliberation) {
        Deliberation savedDeliberation = deliberationService.addDeliberation(deliberation);
        return new ResponseEntity<>(savedDeliberation, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Deliberation> getAllDeliberations() {
        return deliberationService.getAllDeliberations();
    }

    @GetMapping("/get/{id}")
    public Deliberation getDeliberationById(@PathVariable("id") Integer id) {
        return deliberationService.getDeliberationById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Deliberation> updateDeliberation(@Valid @RequestBody Deliberation deliberation) {
        Deliberation updatedDeliberation = deliberationService.updateDeliberation(deliberation);
        return new ResponseEntity<>(updatedDeliberation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeliberation(@PathVariable("id") Integer id) {
        deliberationService.deleteDeliberation(id);
        return new ResponseEntity<>("Deliberation deleted successfully", HttpStatus.OK);
    }
}
