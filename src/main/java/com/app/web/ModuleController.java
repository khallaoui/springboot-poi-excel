package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entities.Module;
import com.app.service.IModuleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final IModuleService moduleService;

    @PostMapping("/create")
    public ResponseEntity<Module> addModule(@Valid @RequestBody Module module) {
        Module savedModule = moduleService.addModule(module);
        return new ResponseEntity<>(savedModule, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/get/{id}")
    public Module getModuleById(@PathVariable("id") Integer id) {
        return moduleService.getModuleById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Module> updateModule(@Valid @RequestBody Module module) {
        Module updatedModule = moduleService.updateModule(module);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable("id") Integer id) {
        moduleService.deleteModule(id);
        return new ResponseEntity<>("Module deleted successfully", HttpStatus.OK);
    }
}
