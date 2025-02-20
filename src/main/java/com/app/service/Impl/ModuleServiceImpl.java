package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Module;
import com.app.repo.ModuleRepo;
import com.app.service.IModuleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements IModuleService {

    private final ModuleRepo moduleRepo;

    @Override
    public Module addModule(Module module) {
        return moduleRepo.save(module);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }

    @Override
    public Module getModuleById(Integer id) {
        return moduleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }

    @Override
    public Module updateModule(Module newModule) {
        Module module = moduleRepo.findById(newModule.getId())
                .orElseThrow(() -> new RuntimeException("Module not found"));
        module.setNom(newModule.getNom());
        return moduleRepo.save(module);
    }

    @Override
    public void deleteModule(Integer id) {
        moduleRepo.deleteById(id);
    }
}
