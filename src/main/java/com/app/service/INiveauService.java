package com.app.service;

import java.util.List;
import com.app.entities.Niveau;

public interface INiveauService {

    Niveau addNiveau(Niveau niveau);
    List<Niveau> getAllNiveaux();
    Niveau getNiveauById(Integer id);
    Niveau updateNiveau(Niveau newNiveau);
    void deleteNiveau(Integer id);
}
