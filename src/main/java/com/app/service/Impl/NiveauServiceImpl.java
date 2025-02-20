package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Niveau;
import com.app.repo.NiveauRepo;
import com.app.service.INiveauService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NiveauServiceImpl implements INiveauService {

    private final NiveauRepo niveauRepo;

    @Override
    public Niveau addNiveau(Niveau niveau) {
        return niveauRepo.save(niveau);
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepo.findAll();
    }

    @Override
    public Niveau getNiveauById(Integer id) {
        return niveauRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Niveau not found with id: " + id));
    }

    @Override
    public Niveau updateNiveau(Niveau newNiveau) {
        Niveau niveau = niveauRepo.findById(newNiveau.getId())
                .orElseThrow(() -> new RuntimeException("Niveau not found"));
        niveau.setAlias(newNiveau.getAlias());
        niveau.setNom(newNiveau.getNom());
        return niveauRepo.save(niveau);
    }

    @Override
    public void deleteNiveau(Integer id) {
        niveauRepo.deleteById(id);
    }
}
