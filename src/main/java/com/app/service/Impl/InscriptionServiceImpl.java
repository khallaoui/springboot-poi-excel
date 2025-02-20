package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Inscription;
import com.app.repo.InscriptionRepo;
import com.app.service.IInscriptionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl implements IInscriptionService {

    private final InscriptionRepo inscriptionRepo;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepo.save(inscription);
    }

    @Override
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepo.findAll();
    }

    @Override
    public Inscription getInscriptionById(Integer id) {
        return inscriptionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription not found with id: " + id));
    }

    @Override
    public Inscription updateInscription(Inscription newInscription) {
        Inscription inscription = inscriptionRepo.findById(newInscription.getId())
                .orElseThrow(() -> new RuntimeException("Inscription not found"));
        inscription.setStatut(newInscription.getStatut());
        return inscriptionRepo.save(inscription);
    }

    @Override
    public void deleteInscription(Integer id) {
        inscriptionRepo.deleteById(id);
    }
}
