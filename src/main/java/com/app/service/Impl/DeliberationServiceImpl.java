package com.app.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Deliberation;
import com.app.repo.DeliberationRepo;
import com.app.service.IDeliberationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliberationServiceImpl implements IDeliberationService {

    private final DeliberationRepo deliberationRepo;

    @Override
    public Deliberation addDeliberation(Deliberation deliberation) {
        return deliberationRepo.save(deliberation);
    }

    @Override
    public List<Deliberation> getAllDeliberations() {
        return deliberationRepo.findAll();
    }

    @Override
    public Deliberation getDeliberationById(Integer id) {
        return deliberationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Deliberation not found with id: " + id));
    }

    @Override
    public Deliberation updateDeliberation(Deliberation newDeliberation) {
        Deliberation deliberation = deliberationRepo.findById(newDeliberation.getId())
                .orElseThrow(() -> new RuntimeException("Deliberation not found"));
        deliberation.setAnneeUniversitaire(newDeliberation.getAnneeUniversitaire());
        deliberation.setDateDeliberation(newDeliberation.getDateDeliberation());
        return deliberationRepo.save(deliberation);
    }

    @Override
    public void deleteDeliberation(Integer id) {
        deliberationRepo.deleteById(id);
    }


}
