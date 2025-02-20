package com.app.service;

import java.util.List;
import com.app.entities.Enseignant;

public interface IEnseignantService {

    Enseignant addEnseignant(Enseignant enseignant);
    List<Enseignant> getAllEnseignants();
    Enseignant getEnseignantById(Integer id);
    Enseignant updateEnseignant(Enseignant newEnseignant);
    void deleteEnseignant(Integer id);
}
