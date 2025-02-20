package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Element;
import com.app.service.IElementService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/Elements")
@RequiredArgsConstructor
public class ElementController {

    private final IElementService elementService;

    @PostMapping("/create")
    public ResponseEntity<Element> addElement(@Valid @RequestBody Element element) {
        Element savedElement = elementService.addElement(element);
        return new ResponseEntity<>(savedElement, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Element> getAllElements() {
        return elementService.getAllElement();
    }

    @GetMapping("/get/{id}")
    public Element getElementById(@PathVariable("id") Integer id) {
        return elementService.getElementById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Element> updateElement(@Valid @RequestBody Element element) {
        Element updatedElement = elementService.updateElement(element);
        return new ResponseEntity<>(updatedElement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable("id") Integer id) {
        elementService.deleteElement(id);
        return new ResponseEntity<>("Element deleted successfully", HttpStatus.OK);
    }
}