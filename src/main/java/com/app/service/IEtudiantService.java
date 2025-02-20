package com.app.service;

import java.util.List;
import com.app.entities.Etudiant;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Integer id);
    Etudiant updateEtudiant(Etudiant newEtudiant);
    void deleteEtudiant(Integer id);
}
