package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Enseignant;
import com.app.repo.EnseignantRepo;
import com.app.service.IEnseignantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnseignantServiceImpl implements IEnseignantService {

    private final EnseignantRepo enseignantRepo;

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepo.save(enseignant);
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepo.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Integer id) {
        return enseignantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant not found with id: " + id));
    }

    @Override
    public Enseignant updateEnseignant(Enseignant newEnseignant) {
        Enseignant enseignant = enseignantRepo.findById(newEnseignant.getId())
                .orElseThrow(() -> new RuntimeException("Enseignant not found"));
        enseignant.setNom(newEnseignant.getNom());
        enseignant.setPrenom(newEnseignant.getPrenom());
        enseignant.setNumTele(newEnseignant.getNumTele());
        enseignant.setMail(newEnseignant.getMail());
        return enseignantRepo.save(enseignant);
    }

    @Override
    public void deleteEnseignant(Integer id) {
        enseignantRepo.deleteById(id);
    }
}
