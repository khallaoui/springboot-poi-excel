package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Etudiant;
import com.app.repo.EtudiantRepo;
import com.app.service.IEtudiantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
    }

    @Override
    public Etudiant updateEtudiant(Etudiant newEtudiant) {
        Etudiant etudiant = etudiantRepo.findById(newEtudiant.getId())
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
        etudiant.setCne(newEtudiant.getCne());
        etudiant.setCni(newEtudiant.getCni());
        etudiant.setNom(newEtudiant.getNom());
        etudiant.setPrenom(newEtudiant.getPrenom());
        etudiant.setType(newEtudiant.getType());
        return etudiantRepo.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepo.deleteById(id);
    }
}
