package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Filiere;
import com.app.repo.FiliereRepo;
import com.app.service.IFiliereService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FiliereServiceImpl implements IFiliereService {

    private final FiliereRepo filiereRepo;

    @Override
    public Filiere addFiliere(Filiere filiere) {
        return filiereRepo.save(filiere);
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereRepo.findAll();
    }

    @Override
    public Filiere getFiliereById(Integer id) {
        return filiereRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Filiere not found with id: " + id));
    }

    @Override
    public Filiere updateFiliere(Filiere newFiliere) {
        Filiere filiere = filiereRepo.findById(newFiliere.getId())
                .orElseThrow(() -> new RuntimeException("Filiere not found"));
        filiere.setAnneeAcc(newFiliere.getAnneeAcc());
        filiere.setAnneeFinAcc(newFiliere.getAnneeFinAcc());
        filiere.setIntitule(newFiliere.getIntitule());
        filiere.setAlias(newFiliere.getAlias());
        return filiereRepo.save(filiere);
    }

    @Override
    public void deleteFiliere(Integer id) {
        filiereRepo.deleteById(id);
    }
}
