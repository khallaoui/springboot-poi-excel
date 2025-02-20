package com.app.service;

import java.util.List;
import com.app.entities.Module;

public interface IModuleService {

    Module addModule(Module module);
    List<Module> getAllModules();
    Module getModuleById(Integer id);
    Module updateModule(Module newModule);
    void deleteModule(Integer id);
}
